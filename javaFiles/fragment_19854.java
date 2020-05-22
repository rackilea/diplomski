.switchMap(s -> getDataManager()
               .getHosts(getDataManager().getDeviceToken(), s)
//             .observeOn(Schedulers.io())
               .subscribeOn(Schedulers.io())   // <-------------------------
)
.observeOn(AndroidSchedulers.mainThread())
//.subscribeOn(Schedulers.io())   // <--------------------------------------
.subscribe(hostResponses -> {