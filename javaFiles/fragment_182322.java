class DataRepository {

    private var completedSubject = BehaviorSubject.create<Boolean>()

    fun dataFetched(): Completable {
        return completedSubject.take(1).toCompletable()
    }

    fun fetchData(): Single<DataModel> {
        return dataService.callToApi()
                .map { apiObject ->
                    return@map jsonApiObject.data as DataModel
                }.doOnSuccess { completedSubject.onNext(true) }
    }
}