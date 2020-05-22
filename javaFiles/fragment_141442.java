LinkedList<String> linkedList = new LinkedList<>();
for (String res : listOne) {
    if (res.startsWith("a") || res.startsWith("g")) {
        System.out.println("--> " + res);
    } else {
        System.out.println("** " + res);
        linkedList.add(res);
    }
}
String[] result1 = new String[linkedList.size()];
linkedList.toArray(result1);