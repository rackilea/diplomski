StringSerializer stringSerializer = StringSerializer.get();
BytesArraySerializer bas = BytesArraySerializer.get();


IndexedSlicesQuery<String, String, byte[]> indexedSlicesQuery = 
            HFactory.createIndexedSlicesQuery("your keyspace", stringSerializer, stringSerializer, bas);

indexedSlicesQuery.setColumnFamily("ClientHeaders");
indexedSlicesQuery.setColumnNames("UUID","Cliend_id","IP","Country","Date");
indexedSlicesQuery.addEqualsExpression("Client_id", stringSerializer.toBytes("123"));

QueryResult<OrderedRows<String, String, byte[]>> result = indexedSlicesQuery.execute();