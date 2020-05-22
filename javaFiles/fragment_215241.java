streamForked(Stream.of(new Row("content1", "client1", "location1", 1),
                       new Row("content2", "client1", "location1", 2),
                       new Row("content1", "client1", "location2", 3),
                       new Row("content2", "client2", "location2", 4),
                       new Row("content1", "client2", "location2", 5)),
             rows -> System.out.println(rows.collect(Collectors.groupingBy(Row::getClient,
                                                                           Collectors.groupingBy(Row::getContent,
                                                                                                 Collectors.summingInt(Row::getConsumption))))),
             rows -> System.out.println(rows.collect(Collectors.groupingBy(Row::getClient,
                                                                           Collectors.groupingBy(Row::getLocation,
                                                                                                 Collectors.summingInt(Row::getConsumption))))),
             rows -> System.out.println(rows.collect(Collectors.groupingBy(Row::getContent,
                                                                           Collectors.groupingBy(Row::getLocation,
                                                                                                 Collectors.summingInt(Row::getConsumption))))));

// Output
// {client2={location2=9}, client1={location1=3, location2=3}}
// {client2={content2=4, content1=5}, client1={content2=2, content1=4}}
// {content2={location1=2, location2=4}, content1={location1=1, location2=8}}