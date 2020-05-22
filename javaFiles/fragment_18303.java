List<RssItem>[][] arr = (List<RssItem>[][])new ArrayList<?>[4][4];

    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
            arr[i][j] = new ArrayList<RssItem>();

            arr[i][j].add(new RssItem());
        }
    }

    for (List<RssItem>[] val: arr) {
       for (List<RssItem> val2: val) {
           System.out.println(val2);
       }
    }