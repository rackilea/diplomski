String str = "{\"attachments\":[\"string\"],\"contact\":{\"name\":\"Mahesh\"},\"contactCode\":\"C-0000001\",\"journalEntryCode\":\"JE-0000002\",\"linkedDocuments\":[{\"contactCode\":\"C-0000001\",\"documentCode\":\"0000018\",\"documentItemDetails\":[{\"productCode\":\"P-0000001\"}],\"documentType\":\"QUOTATION\"},{\"contactCode\":\"C-0000002\",\"documentCode\":\"0000019\",\"documentItemDetails\":[{\"productCode\":\"P-0000002\"}],\"documentType\":\"QUOTATION\"}],\"taxAmount\":2.322,\"totalAmount\":12.322,\"unitPriceGstInclusive\":false}";

JSONObject jsonObject = new JSONObject(str);

JSONArray array = jsonObject.getJSONArray("linkedDocuments");
array.getJSONObject(0).put("documentCode", 1234);
System.out.println(jsonObject);