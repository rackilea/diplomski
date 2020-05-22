while (cursor.hasNext()) {
    Document str = cursor.next();

    List<Document> list = (List<Document>)str.get("hobby");

    out.println(list.get(0)); // display specific field
}