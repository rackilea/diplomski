ObjectAccessControl oac = new ObjectAccessControl()
    oac.setEntity("allUsers")
    oac.setRole("READER");

Insert insert = service.objectAccessControls().insert(bucketName, "sounds/1.0/arabic_test22/1000meters.mp3", oac);
insert.execute();