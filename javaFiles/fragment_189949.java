class RepositoryImpl @Inject constructor(private val localRepository: Repository, private val remoteRepository: Repository) : Repository {
    override fun getData(): Single<Data> = remoteRepository.getData()
        .onErrorResumeNext { throwable ->
            if (throwable is IOException) {
                return localRepository.getData()
            }
            return Single.error(throwable)
        }
}