List<String> exampleList = new ArrayList<>(); // Java 7 needed for diamond init
exampleList.add("test");
exampleList.add("test1");
exampleList.add("test2");
exampleList.add("test3");

for(str : exampleList){
    System.out.println(str);
}