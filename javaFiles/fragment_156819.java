// First it is gonna group dbUserIds and apiUserIds between each other. To keep this data, we are gonna use hashMaps
        Map<Long, List<Long>> dbUserIdGroup = new HashMap<Long, List<Long>>();
        Map<Long, List<Long>> apiUserIdGroup = new HashMap<Long, List<Long>>();

        // To demonstrate the test data given by you
        List<ObjectFromDb> dbList = new ArrayList<ObjectFromDb>();
        dbList.add(new ObjectFromDb(1L, 1L));
        dbList.add(new ObjectFromDb(2L, 2L));
        dbList.add(new ObjectFromDb(2L, 3L));
        dbList.add(new ObjectFromDb(3L, 4L));
        dbList.add(new ObjectFromDb(4L, 4L));
        dbList.add(new ObjectFromDb(5L, 4L));
        dbList.add(new ObjectFromDb(6L, 5L));

        // Iterating the given ObjectFromDb instances to group them 
        for (ObjectFromDb objectFromDb : dbList) {

            // Grouping according to dbUserId
            if (dbUserIdGroup.get(objectFromDb.getDbUserId()) == null) {
                List<Long> group = new ArrayList<Long>();
                group.add(objectFromDb.getApiUserId());
                dbUserIdGroup.put(objectFromDb.getDbUserId(), group);
            } else {
                dbUserIdGroup.get(objectFromDb.getDbUserId()).add(objectFromDb.getApiUserId());
            }

            // Grouping according to apiUserId
            if (apiUserIdGroup.get(objectFromDb.getApiUserId()) == null) {
                List<Long> group = new ArrayList<Long>();
                group.add(objectFromDb.getDbUserId());
                apiUserIdGroup.put(objectFromDb.getApiUserId(), group);
            } else {
                apiUserIdGroup.get(objectFromDb.getApiUserId()).add(objectFromDb.getDbUserId());
            }
        }

        // Up to now, we have two grouped hashmaps 
        // dbUserIdGroup ->  {"1":[1],"2":[2,3],"3":[4],"4":[4],"5":[4],"6":[5]} // note that the key of this hashtable is dbUserId
        // apiUserIdGroup ->  {"1":[1],"2":[2],"3":[2],"4":[3,4,5],"5":[6]} //  note that the key of this hashtable is apiUserId
        Set<Long> dbUserIds = dbUserIdGroup.keySet(); // to iterate dbUserId group we get its keys (dbUserIds)

        Set<List<Long>> existanceCheck = new HashSet<>(); // to avoid duplicated data

        List<FinalObject> result = new ArrayList<FinalObject>(); // to keep the result
        for (Long dbUserId : dbUserIds) {
            FinalObject fObject = null;
            List<Long> dbApiIdList = dbUserIdGroup.get(dbUserId);

            if (dbApiIdList.size() == 1) { // if the value is the list with single element
                List<Long> groupedDbUserId = apiUserIdGroup.get(dbApiIdList.get(0));
                if (!existanceCheck.contains(groupedDbUserId)) {
                    fObject = new FinalObject(groupedDbUserId, dbApiIdList);
                    existanceCheck.add(groupedDbUserId);
                    result.add(fObject);
                }
            } else { // if the value is the list with multiple elements
                List<Long> dbUserIdList = new ArrayList<Long>();
                dbUserIdList.add(dbUserId);
                fObject = new FinalObject(dbUserIdList, dbApiIdList);
                result.add(fObject);
            }

        }

        // Now you have a List<FinalObject> result array just like you want.