JSONObject jsonObject = new JSONObject();
jsonObject.put("to", "123456789");
jsonObject.put("msg", "Mensagem Teste");
JSONObject jsonObject1 = new JSONObject();
jsonObject1.put("sendSmsRequest", jsonObject);

StringEntity input = new StringEntity(jsonObject1.toString());