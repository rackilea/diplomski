String lines="hello hello hello hello"
                 +"hi hi hi hi hi hi"
                 +"bye bye bye bye bye";
    String test[]={lines.substring(0,lines.indexOf("hi")),lines.substring(lines.indexOf("hi"),lines.indexOf("bye")),lines.substring(lines.indexOf("bye"))};
    List<String> list=Arrays.asList(test);
    System.out.println(list);