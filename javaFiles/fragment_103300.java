public Map<String,String> getAllLangaugeDataForEn(Integer appId, String language) {
  Map<String,String> result = new HashMap();
  if (language.equalsIgnoreCase("EN")) {
   result  = languageRepository.getEnLanguageList(appId)
            .stream()
            .map(language-> new AbstractMap.SimpleEntry<>(language.getX(),language.getY()))
            .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
   }
     return result;
}