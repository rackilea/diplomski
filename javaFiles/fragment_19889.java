public void testOne(String link) {
    try {
       driver.findElement(By.linkText(link));
    }
    catch (Exception e) {
       System.out.println(link+" failed to find");
    }
}

public void test() {
    testOne("link1");
    testOne("link2");
    testOne("link3");
    testOne("link4");
    testOne("link5");
}