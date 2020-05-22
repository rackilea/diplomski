//this emulates the first network call
    Observable<List<String>> o1 = Observable.just(Arrays.asList("user1", "user2"));
    //when the data arrives, you may transform it 
    Observable<List<String>> m1 = o1.map(new Func1<List<String>, List<String>>() {
        @Override
        public List<String> call(List<String> users) {
            return users;
        }
    });

    //and the same for the second network call
    Observable<List<String>> o2 = Observable.just(Arrays.asList("group1", "group2"));
    Observable<List<String>> m2 = o2.map(new Func1<List<String>, List<String>>() {
        @Override
        public List<String> call(List<String> groups) {
            return groups;
        }
    });

    //when both network calls succeed you can merge results using zip method    
    Observable<Map<String, List<String>>> result =  Observable.zip(m1, m2, new Func2<List<String>, List<String>, Map<String, List<String>>>() {
        @Override
        public Map<String, List<String>> call(List<String> users, List<String> groups) {
            Map<String, List<String>> result = new HashMap<String, List<String>>();
            for(String user: users){
                result.put(user, groups);
            }
            return result;
        }
    });
    /// now you can return the result


    /// finally you have to subscibe to get the results, e.g:
    result.subscribe(new Action1<Map<String, List<String>>>() {
        @Override
        public void call(Map<String, List<String>> stringListMap) {
            for(String user: stringListMap.keySet()){
                System.out.println("User :"+user+", groups :"+stringListMap.get(user));
            }
        }
    });