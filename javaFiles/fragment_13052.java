JSONObject data1 = new JSONObject();
data1.put("type","one");
Thread1=new Two(data1);
Thread1.setName("one");
Thread1.start();

JSONObject data2 = new JSONObject();
data2.put("type","two");
Thread2=new Two(data2);
Thread2.setName("two");
Thread2.start();