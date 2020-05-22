while (cursor.hasNext()) {

    DBObject document = cursor.next();

    System.out.println(document.get("imageblock"));
    System.out.println(document.get("textblock"));
}