private static void saveExcelFile(HtmlUnitDriver driver)  {
    Method m = driver.getClass().getDeclaredMethod("lastPage", null);
    m.setAccessible(true);
    Object obj = m.invoke(driver, null);

    Page page = (Page) obj;

    InputStream stream = page.getWebResponse().getContentAsStream();

    FileOutputStream fos = new FileOutputStream("d:/load.xls");

    int c;

    while ((c = stream.read()) != -1) {
        fos.write(c);
    }

    fos.close();
}