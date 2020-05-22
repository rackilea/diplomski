// imitate infinite hot service
PublishSubject<Report> service = PublishSubject.create();

// special report indicating the service has no reports
Report NO_REPORT = new Report();

AtomicBoolean hasValue = new AtomicBoolean();

service
// we'll need the main value for both emission and control message
.publish(main ->
     // this will keep "listening" to main and allow a timeout as well
     main.mergeWith(
         // signal the empty report indicator
         Observable.just(NO_REPORT)
         // after some grace period so main can emit a real report
         .delay(100, TimeUnit.MILLISECONDS)
         // but if the main emits first, don't signal the empty report
         .takeUntil(main)
     )
)
.subscribeOn(Schedulers.io())
.observeOn(AndroidSchedulers.mainThread())
.subscribe(report -> {
     if (report == NO_REPORT) {
         // even if this onNext is serialized, NO_REPORT may get emitted
         if (!hasValue.get()) {
             // display empty report
         }
     } else {
         // this indicates a NO_REPORT should be ignored onward
         hasValue.set(true);
         // display normal report
     }
}, error -> {  /* show error */ })

Thread.sleep(200); // Thread.sleep(50)
service.onNext(new Report());