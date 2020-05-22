String description="Big data is a broad term for data sets so large or complex that traditional data processing applications are inadequate. البيانات الضخمة هي عبارة عن مجموعة من مجموعة البيانات الضخمة جداً والمعقدة لدرجة أنه يُصبح من الصعب معالجتها باستخدام أداة واحدة فقط من أدوات إدارة قواعد البيانات أو باستخدام تطبيقات معالجة البيانات التقليدية. ";
Pattern p = Pattern.compile("\\p{InArabic}+";
Matcher m = p.matcher(description);
while(m.find()){
    System.out.println(m.group());
}