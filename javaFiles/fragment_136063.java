@Test
    public void attributeColumnGenratortest()
    {

        AttributeColumnGenerator columnGenerator = new AttributeColumnGenerator();

        Table table = new Table();
        String columnId = "test";
        table.addContainerProperty(columnId, String.class, "");

        String itemId = "item1";
        Item item = table.addItem(itemId);
        item.getItemProperty(columnId).setValue("Value of item1");


        Label generateObject = (Label)columnGenerator.generateCell(table, itemId, columnId);

        // Assert any properties of the returned Component.
        // In this snippet, I only printOut the boolean comparaison.
        System.out.println( "Value of item 1".equals(generateObject.getValue()));
    }