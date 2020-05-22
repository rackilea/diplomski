@GlideModule
class MyAppGlideModule : AppGlideModule() {

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        super.registerComponents(context, glide, registry)
        val app = context.applicationContext as MyApplication
        registry.append(Data::class.java, ByteBuffer::class.java, MyImageLoaderFactory(app.api))
    }
}

class MyImageLoaderFactory(private val api: Api) : ModelLoaderFactory<Data, ByteBuffer> {

    override fun teardown() {

    }

    override fun build(multiFactory: MultiModelLoaderFactory): ModelLoader<Data, ByteBuffer> {
        return MyImageLoader(api)
    }
}

class MyImageLoader(private val api: Api) : ModelLoader<Data, ByteBuffer> {

    override fun buildLoadData(model: Data, width: Int, height: Int, options: Options): ModelLoader.LoadData<ByteBuffer> {
        val key = "code:${model.code};width:$width;height:$height"
        return ModelLoader.LoadData<ByteBuffer>(ObjectKey(key), MyImageDataFetcher(api, GetImageRequest().apply { data = model }))
    }

    override fun handles(model: Data): Boolean {
        return true
    }
}

class ClmImageDataFetcher(private val api: Api, private val request: GetImageRequest) : DataFetcher<ByteBuffer> {

    private val disposables = CompositeDisposable()

    override fun cleanup() {
        disposables.clear()
    }

    override fun loadData(priority: Priority, callback: DataFetcher.DataCallback<in ByteBuffer>) {
        api.getImage(request)
                .map { it.image.decodeBase64() }
                .subscribe({ callback.onDataReady(ByteBuffer.wrap(it)) }, {
                    if (it is Exception) {
                        callback.onLoadFailed(it)
                    } else {
                        callback.onLoadFailed(MyException(it))
                    }
                })
                .addTo(disposables)
    }

    override fun cancel() {
        disposables.clear()
    }

    override fun getDataClass(): Class<ByteBuffer> {
        return ByteBuffer::class.java
    }

    override fun getDataSource(): DataSource {
        return DataSource.REMOTE
    }

}