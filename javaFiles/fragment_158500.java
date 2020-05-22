Document snewDoc = new Document();
snewdoc.append("Name", snew.getName());
snewdoc.append("Brand", snew.getBrand());
snewdoc.append("Type", snew.getType());
snewdoc.append("Color", snew.getColor());
snewdoc.append("Size", snew.getSize());
snewdoc.append("Price", snew.getPrice());
Document updateDoc = new Document("$set",snewDoc);
this.collection.updateOne(sfilterdoc, updateDoc);