String relatedObjectId = "objectId_23445"
    Query query = CouchbaseViews.GetAllMyTypeItems().createQuery();            
            query.setDescending(true);

            ArrayList<Object> startKey = new ArrayList<Object>();            
        startKey.add(relatedObjectId );

            ArrayList<Object> endKey = new ArrayList<Object>();
            endKey.add(relatedObjectId );
        endKey.add(new HashMap<>());

            query.setStartKey(endKey);
            query.setEndKey(startKey);