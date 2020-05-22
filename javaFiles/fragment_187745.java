IntStream.range(0, recs.size())
    .mapToObj(i -> {
       Rec rec = recs.get(i);
       rec.setRecordIndex(i);
       return rec;
    })
    .parallel()
    .forEach(rec -> foo(ProgressInfo, rec));