Map<String, Class<OCRResultVo.DataBean.WordsResultBean>> classMap = new HashMap<String, Class<>>();
classMap.put("words_result", OCRResultVo.DataBean.WordsResultBean.class);
JSONObject  jsStr = JSONObject.fromObject(strJson);
jsStr.remove("unknown");

ObjResult  = (OCRResultVo) JSONObject.toBean(jsStr,OCRResultVo.class,classMap);
ObjResult.setId(UUID.randomUUID().toString());