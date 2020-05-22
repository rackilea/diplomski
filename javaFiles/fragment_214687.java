String token = "";
while (myFile.hasNext()) {
    token = myFile.next();
    collection.add(new Records(token));

}