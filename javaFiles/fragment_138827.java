List<Item> theItems = new ArrayList<TestXML.Item>();
    for(int i= 0; i<3 ; i++)
    {
    theItems.add(new Item("item "+i, "description of item "+i, "n.s","http://www.stackoverflow.com"));
    }

    System.out.println( createRss2(theItems));