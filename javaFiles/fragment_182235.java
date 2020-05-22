Map<String,Object> headerMap = new HashMap<String, Object>();
  headerMap.put(key,value)
  headerMap.put(key1,value1)
  headerMap.put(key2,value2)
  builder.headers(headerMap);
  pchannel.basicPublish("","best_queue",builder.build(),post.getBytes());
  System.out.println(" [x] Sent '" + msgcount.toString() + "' MESSAGES.");