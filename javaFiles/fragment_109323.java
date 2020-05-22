BasicDBObject match = new BasicDBObject("$match", new BasicDBObject("bookingDate", 
                new BasicDBObject("$gte", OperationsUtil.getISODateFromUIDate(startDate)).append("$lte",OperationsUtil.getISODateFromUIDate(endDate)).append("$ne", null)));
     BasicDBObject match1 = new BasicDBObject("$match", new BasicDBObject("bookingDeleted",false).append("tour.travelStatus",new BasicDBObject("$ne", "Unreceipted")));
     BasicDBList addition=new BasicDBList();
     addition.add("$bookingDate");
     addition.add(OperationsConstant.UTC_TO_IST_MILLISECONDS);
     BasicDBObject monthDoc=new BasicDBObject("$add",addition);
     BasicDBObject project = new BasicDBObject("$project",new BasicDBObject("_id",0).append("totalAmount",1).append("totalPax",1).append("month",new BasicDBObject("$month",monthDoc)));
     DBObject group = new BasicDBObject("$group", new BasicDBObject("_id","$month")
             .append("totalPaxCount", new BasicDBObject("$sum", "$totalPax")).append("totalAmount",new BasicDBObject("$sum", "$totalAmount")));
     DBObject sort = new BasicDBObject("$sort", new BasicDBObject("_id", 1));
     AggregationOutput cursor = bookingCollection.aggregate(match,match1,project,group,sort);