String name = nameField.getText();
String manufacturer = manufacturerField.getText();
String color = colorField.getText();
String price = priceField.getText();

BasicDBObject doc = new BasicDBObject("title", "MongoDB").
        append("name", name ).
        append("manufacturer", manufacturer).
        append("colour", color).
        append("price", price);
        coll.insert(doc);