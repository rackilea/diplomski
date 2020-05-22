Pattern p = Pattern.compile("(?![IVX]+\\.\\s|[a-z]+\\)\\s).*");

System.out.println(p.matcher("a) prueba de inciso").matches());
System.out.println(p.matcher("I. prueba de fraccion").matches());
System.out.println(p.matcher("Prueba parrafo").matches());
System.out.println(p.matcher("I am good").matches());
System.out.println(p.matcher("another test").matches());