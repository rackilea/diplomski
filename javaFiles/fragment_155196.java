public static void main(String[] args) {
    SelectiveList selectiveList = new SelectiveList();
    selectiveList.add("Potato");
    selectiveList.add(1);
    selectiveList.add(true);
    System.out.println(selectiveList.size()); // prints 0
    // these objects need to be initialized, but their contents do not
    // matter
    selectiveList.addPermittedObject(new String());
    selectiveList.addPermittedObject(new Boolean(false));
    selectiveList.addPermittedObject(new Integer(1));
    selectiveList.add("Potato");
    selectiveList.add(1);
    selectiveList.add(true);
    System.out.println(selectiveList.size()); // prints 3
}