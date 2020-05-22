MenuItem toSave = new MenuItem("test", 6.3);
toSave.setId(1);
ofy().save().entity(toSave).now();
ofy().clear(); //Make sure we're not just looking at the current session.
MenuItem loaded = ofy().load().type(MenuItem.class).id(1).get();
assertEquals(loaded.getName(), "test");
assertEquals(loaded.getPrice(), 6.3);