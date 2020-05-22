List<String> strList = new List<>();
strList.add("日");
strList.add("蘋"); 

Collator collator = Collator.getInstance(Locale.TRADITIONAL_CHINESE);
collator.setStrength(Collator.PRIMARY);
Collections.sort(strList, collator);