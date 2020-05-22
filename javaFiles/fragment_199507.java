FindIterable<Document> docs = col.find(query);
if (docs == null) {
    //no values found
}

for(Document doc : docs) {
    //access documents e.g. doc.get()
}