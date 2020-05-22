for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
    String str = iterator.next();
    System.out.println("Checking "+str);
    if (str.equals("noob2")) {
        list.remove("noob1");
        list.remove("noob3");
    }
}