Field contentFieldLower = new Field("content", "", YES, NOT_ANALYZED);
document.add(contentFieldLower);
Field contentField = new Field("content", "", YES, ANALYZED);
document.add(contentField);
Field contentFieldNotAnalysed = new Field("content", "", YES, NOT_ANALYZED);
document.add(contentFieldNotAnalysed);