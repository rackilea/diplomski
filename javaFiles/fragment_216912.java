Observable.from(Arrays.asList(1,2,3,4,5,6))
    .scan(new ArrayList<>(), (array, item) -> {
           array.add(item)     
           return array;
          })
    .map(collectedItems -> {
          //access all previous and curent emissions on every new
          return collectedItems;
        })