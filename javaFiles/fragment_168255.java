...
    DBObject selectQuery = new BasicDBObject("userEmail", rest.getEmailUser());
    selectQuery.append("reservations.idRest", rest.getId());

    BasicDBObject updateFields = new BasicDBObject();
    updateFields.put("reservations.$.idRest", rest.getEmailUser());
    updateFields.put("reservations.$.userPhone", rest.getPhoneUser());
    updateFields.put("reservations.$.date", rest.getFecha());
    updateFields.put("reservations.$.hour", rest.getHora());;

    DBObject updateQuery = new BasicDBObject();
    updateQuery.put("$set", updateFields);
    collReservationByUser.update(selectQuery, updateQuery, true, true); 
    ...