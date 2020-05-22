public void doSomething() {
    Map<String,String> beans = new HashMap<String,String>();
    beans.put("df", new SimpleDateFormat("dd.MM.yyyy"));
    XLSTransformer transformer = new XLSTransformer();
    transformer.transformXLS("template.xls", beans, "result.xls");
}