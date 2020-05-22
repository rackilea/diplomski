List<Dummy> myList = new ArrayList<Dummy>() {{
     add(new Dummy("test", ""));
     add(new Dummy("boo", "o"));
}};

System.out.println( myList.toString());
System.out.println( Iterables.transform(myList, Dummy.getA)); // returns ["test", "boo"]
System.out.println( Iterables.transform(myList, Dummy.getB)); // returns ["", "o"]