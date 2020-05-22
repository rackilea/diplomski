mService.getExampleObject().flatMap(new Func1<List<ExampleObject>, Observable<ExampleObject>>() {
        @Override
        public Observable<List<ExampleObject>> call(List<ExampleObject> exampleObjects) {
            List<Observable<ExampleObject>> allTheObservables = new ArrayList<Observable<ExampleObject>>();
            for (ExampleObject entry : exampleObjects) {
                allTheObservables.add(mService.getMissingObjectByFoo(foo).map(new Func1<MissingObject, ExampleObject>() {
                    @Override
                    public ExampleObject call(MissingObject missingObject) {
                        return entry.setBar(missingObject);
                    }
                }));
            }
            return Observable.zip(allTheObservables, new FuncN<ExampleObject>() {
                @Override
                public ExampleObject call(ExampleObject... args) {
                    return Arrays.asList(args);
                }
            });
        }
    });