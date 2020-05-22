Observable<Observable<T>> obss = Observable.just(
  obs1.compose(applyMeasurement(T.class, "tag1")),
  obs2.compose(applyMeasurement(T.class, "tag2")),
  obs3.compose(applyMeasurement(T.class, "tag3")),
);

Observable.concat(obss).subscribe();