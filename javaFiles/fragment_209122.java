Stream.of(new Data("Utah"        ,5 ),
          new Data("Nevada"      ,6 ),
          new Data("California"  ,12),
          new Data("Oregon"      ,8 ),
          new Data("Utah"        ,9 ),
          new Data("California"  ,10),
          new Data("Nevada"      ,4 ),
          new Data("Nevada"      ,4 ),
          new Data("Oregon"      ,17),
          new Data("California"  ,6 ))
      .collect(Collectors.groupingBy(
          d -> d.name,
          Collectors.summarizingInt(d -> d.value)))
      .forEach((name, summary) -> System.out.println(name + ": " + summary));