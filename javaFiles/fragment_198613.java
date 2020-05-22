Map<Integer, String> result = 
             Sets.difference(right.entrySet(), left.entrySet())
                 .stream()
                 .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

    System.out.println(result);