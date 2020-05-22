MyTimes[] myTimes = {
            new MyTimes("Polly", "2019-03-06T17:00:00Z"),
            new MyTimes("Margaret", "2019-03-08T09:00:00Z"),
            new MyTimes("Jane", "2019-03-01T06:00:00Z")
    };

    Arrays.sort(myTimes, Comparator.comparing(MyTimes::getStartDate));

    Arrays.stream(myTimes).forEach(System.out::println);