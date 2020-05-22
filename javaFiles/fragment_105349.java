String paramMap = new HashMap<String, String>();
paramMap.put("attribute", "segmentation");

ModelInput.Builder builder = new ModelInput.Builder(109739281L, 20L, paramMap);
builder.preference(Preference.SECONDARY).timeout(1000L).debug(true);

ModelInput modelInput = builder.build();