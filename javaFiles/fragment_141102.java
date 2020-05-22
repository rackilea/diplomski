Observable.fromIterable(idList)
            .map(new Function<Integer, Object>() {
                     @Override
                     public Object apply(Integer id) throws Exception {
                         JSONObject singleObject = new JSONObject();
                         singleObject.put("id:", id);
                         singleObject.put("timestamp:", timestampList.get(counter[0]));
                         counter[0]++;
                         combinedArray.put(singleObject);
                         return Observable.just(combinedArray);
                     }
                 }
            )
            .toList()  //jsonArrayObservable is observable json array, if you want to your later on
            .doOnSuccess(jsonArrayObservable -> Log.d("jsonArrayObservable -> ", combinedArray.toString()))
            .subscribe();