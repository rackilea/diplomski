Topic newT = Topic(1L, 'yyy', null);
Long id = newT.getID();

Topic oldT = Topic.findByID(id);  //Retrieve the old values from the database

Author newAuthor = newT.getAuthor(); //null

if (newAuthor != null) {  //This test will fail
  oldT.setAuthor(newAuthor);  //Update the old object
}

String newContent = newT.getContent(); //Not null

if (newContent != null) {
  oldT.setContent(newContent);  //Update the old object
}

// Now the object oldT holds all the new, non-null data.  Change the update tests as you see fit, of course, and then...

oldT.save();  //Update the object in the database.