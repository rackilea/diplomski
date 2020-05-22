public void portfolioRenewalSearch(String portfolioId) throws Exception {
    try {
        driver.findElement(By.xpath("//input[@accesskey="+portfolioId+"]"))
                .click();
    } catch (AssertionError Ae) {
        Ae.printStackTrace();
    }
}