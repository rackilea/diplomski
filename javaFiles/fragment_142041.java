UpdateBuilder<Person, Long> updateBuilder = personDao.updateBuilder();
updateBuilder.where().in("id", arrayOfIdsOfPersons); //I just got all the ids of each object I want to update
updateBuilder.updateColumnValue("home_id", secondHome); //changed the mapping to point to another `Home Object`
updateBuilder.update();

homeDao.refresh(secondHome); //not sure if I need this one though.