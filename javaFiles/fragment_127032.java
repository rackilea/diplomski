// Referencing fields that might be contained in myrecord
myrecord.from(mybean, User.NAME, User.DESCRIPTION, User.SOME_OTHER_FIELD);

// Referencing field names that might be contained in myrecord
myrecord.from(mybean, "name", "description", "some_other_field");

// Referencing field indexes that might be contained in myrecord
myrecord.from(mybean, 3, 4, 7);