List<String> list = new ArrayList<String>
        (Arrays.asList("noob1", "noob2", "noob3", "noob4"));

System.out.println(list);

for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
    String str = iterator.next();
    if (str.equals("noob3")) {
        System.out.println("Checking "+str);
        list.remove(str);
    }
}
System.out.println(list);