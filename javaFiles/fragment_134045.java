pipeline.add(new BasicDBObject('$match', criteria))
        pipeline.add(new BasicDBObject('$project', theProjections))

        if (cats.length != 0) {
            pipeline.add(new BasicDBObject('$match', criteriaCat))
        }
        pipeline.add(new BasicDBObject('$sort', sorting))

        //and by default
        iterable = collection.aggregate(pipeline)