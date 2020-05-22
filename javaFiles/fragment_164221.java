public static final String COUNT_STATEMENT = "select count(*) as count " +
        "from bucketName " +
        "where id is not missing " + 
        "and docType = 'docId' " +
        "and id IN $ids " + 
        "and publishTimestamp between $startTime and $endTime";