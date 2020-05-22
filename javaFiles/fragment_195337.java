List<String> stringColl = Arrays.asList("jamesbond","danielocean");

    // Java 8 
    stringColl.forEach(stringElem -> System.out.println(stringElem));

    // Java 7 or below 
    for(String stringElem : stringColl){
        System.out.println(stringElem);
    }