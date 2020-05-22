Map<String, String> mapping = new HashMap();
mapping.put("frak","f***");

String censoredMsg = message;
for (String word : mapping.KeySet()) {
  censoredMsg = censoredMsg.replaceAll(word, mapping.get(word));
}