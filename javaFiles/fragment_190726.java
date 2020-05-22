class MyList { // notice it does not extend ArrayList<MyListElement> anymore

    // Now I set this list in inline mode
    @ElementList(entry = "MyListElement", type = MyListElement.class, inline = true)
    private ArrayList<MyListElement> elementList;

    @Attribute(name = "MyListAttribute")
    private Long attribute;
}