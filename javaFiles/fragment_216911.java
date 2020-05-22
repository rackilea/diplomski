Observable.from(Arrays.asList(1,2,3,4,5,6))
      .collect(ArrayList::new,
        (array, item) -> {
            //access previous and current emissions
            array.add(item);
        })