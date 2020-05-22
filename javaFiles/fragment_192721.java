public Long getCountOfItems(String tableName) {         
        Long numberOfItems = 0L;
        try {
            ScanResult result = null;    
            do {

                ScanRequest scanRequest = new ScanRequest().withTableName(tableName);
                if (result != null) {
                    scanRequest.setExclusiveStartKey(result.getLastEvaluatedKey());
                }

                result = dynamoDBClient.scan(scanRequest);

                numberOfItems = numberOfItems + result.getItems().size();


            } while (result.getLastEvaluatedKey() != null);

        } catch (Exception db) {    
            throw new RuntimeException("Record count couldn't be calculated ...", db);    
        }           
        System.out.println(numberOfItems);

        return numberOfItems;

    }