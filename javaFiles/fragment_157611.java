service.getContributorsObservable("square", "dagger")
        .flatMap(new Func1<List<Contributor>, Observable<List<String>>>() {
            @Override
            public Observable<List<String>> call(List<Contributor> contributors) {
                List<Observable<String>> allTheObservables = new ArrayList<>(contributors.size());
                for (final Contributor contributor : contributors) {
                    allTheObservables.add(service.getContributorsObservable(contributor.login).map(new Func1<User, String>() {

                        @Override
                        public String call(User user) {
                            return contributor.login + " is " + user.name;
                        }
                    }));
                }
                return Observable.zip(allTheObservables, new FuncN<List<String>>() {
                    @Override
                    public List<String> call(Object... args) {
                        return Arrays.asList((String[]) args);
                    }
                });
            }
        });