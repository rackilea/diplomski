//first get industryIdentifiers array
for (int i = 0; i < jIdentifiersArray.length(); i++) {
                JSONObject identifier = jIdentifiersArray.getJSONObject(i);
                String type = identifier.getString("type");
                if (type.equals("ISBN_10")){
                   book.setISBN10(identifier.getString("identifier"));
                }
                else if (type.equals("ISBN_13")){
                   book.setISBN13(identifier.getString("identifier"));
                }
}