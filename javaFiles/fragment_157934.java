List<Entity> listEntity = yourservicenameTogetDataFromDataBase();

//grouping By id_client 
Map<Integer, List<Integer>> groupingMap = listEntity
      .stream()
   .collect(Collectors.groupingBy(o->o.getIdClient()));

//result

for (Entry<Integer, List<Integer>> entry : groupingMap.entrySet()) {
        System.err.println("Key = " + entry.getKey() +" , Values :");
          for (Integer  i : entry.getValue()) {
      System.err.println(i);

      }
  }

Key = 1 , Values :
  10
  15
  13

Key = 2 , Values :

  20
  40
  9
.....