// don't set id field
//OR
//set using default constructor of ObjectId
moIADoc.setId(new ObjectId());
//OR use other constructors e.g.
moIADoc.setId(new ObjectId(new Date(), 123456));