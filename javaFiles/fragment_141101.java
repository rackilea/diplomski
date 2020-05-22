JSONArray combinedArray = new JSONArray();


    List<Integer> idList = Arrays.asList(6, 7, 8, 9, 10, 11);
    List<Integer> timestampList = Arrays.asList(122402538, 12240345, 122496, 122617, 1227473, 1228495);

    final int[] counter = {0}; // assuming your both array are of same size.
    Observable.fromIterable(idList)
            .map(id -> {
                        JSONObject singleObject = new JSONObject();
                        singleObject.put("id:", id);
                        singleObject.put("timestamp:", timestampList.get(counter[0]));
                        counter[0]++;
                        combinedArray.put(singleObject);
                        return Observable.just(combinedArray);
                    }
            )
            .toList()  //jsonArrayObservable is observable json array, if you want to your later on
            .doOnSuccess(jsonArrayObservable -> Log.d("jsonArrayObservable -> ", combinedArray.toString()))
            .subscribe();