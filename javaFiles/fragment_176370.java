String json = "[" +
        "{ \"$group\": { "+
            "\"_id\": { " +
                "\"month\": { \"$month\": \"$date\" }, " +
                "\"day\": { \"$dayOfMonth\":\"$date\" }, " +
                "\"year\": { \"$year\": \"$date\" } " +
            "}, " +
            "\"totalPrice\": { \"$sum\": { \"$multiply\": [ \"$price\", \"$quantity\" ] } }, " +
            "\"averageQuantity\": { \"$avg\": \"$quantity\" }, " +
            "\"count\": { \"$sum\": 1 } " +
        "}}" +
    "]";

    BasicDBList pipeline = (BasicDBList)com.mongodb.util.JSON.parse(json);