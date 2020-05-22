List<Entry> uploadResults = Arrays.asList(
        new Entry("January","10","2018",236.9f),
        new Entry("January","11","2018",267.6f),
        new Entry("January","12","2018",278.1f),
        new Entry("January","13","2018",246.9f),
        new Entry("January","14","2018",262.3f),
        new Entry("January","15","2018",288.6f),
        new Entry("February","2","2018",199.7f),
        new Entry("February","3","2018",134.6f),
        new Entry("February","4","2018",200.8f),
        new Entry("February","5","2018",198.2f),
        new Entry("March","9","2018",169.7f),
        new Entry("March","10","2018",168.3f),
        new Entry("March","11","2018",179.4f)
);

Map<String, Double> collect = uploadResults.stream().collect(
        Collectors.groupingBy(Entry::getMonth, Collectors.summingDouble(Entry::getPowerOutput)));

System.out.println(collect);