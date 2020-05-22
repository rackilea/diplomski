val mPublishProcessor: FlowableProcessor<String> = PublishProcessor.create<String>().toSerialized()

list.forEach {
    doSomeAsyncTasksWithCallback(string) {
      mPublishProcessor.onNext(string)
    }
}

mPublishProcessor
.buffer(list.size)
.observeOn(AndroidSchedulers.mainThread())
.subscribe {
   doSomethingWithTheCollectedStrings()
}