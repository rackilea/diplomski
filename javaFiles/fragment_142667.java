List<Tuple2<String,String>> ls =
        vec(tup("Hello", "World"),
            tup("Pair", "Words"),
            tup("Another", "Pair"));

ls.forEach(pair -> System.out.println("First: " + pair._1() +
                                      " Second: " + pair._2()));