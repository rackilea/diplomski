List<String> stringList = new ArrayList<String>(Arrays.asList("string1","string2","string3"));
        String list= String.join(",", stringList
                .stream()
                .map(name -> ("'" + name + "'"))
                .collect(Collectors.toList()));

System.out.println(list); // prints 'string1','string2','string3'