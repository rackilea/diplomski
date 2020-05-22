HttpEntity entity = MultipartEntityBuilder.create()
.addTextBody("inner_key1", jsonObject.get("inner_key1").toString())
.addTextBody("inner_key2", jsonObject.get("inner_key2").toString())
.addTextBody("inner_key3", jsonObject.get("inner_key3").toString())
.addBinaryBody("image", new File(imagePath))
.build();