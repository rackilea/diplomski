|check|field exists|testknop|inloggen gelukt|


public String fieldExists(String fieldName) {
    // Als het element niet gevonden kan worden treed eer een exception op dus assert is niet
    // nodig
    try {
        driver.findElement(By.id(fieldName));
    } catch (NoSuchElementException e) {
        return "Inloggen mislukt";
    }
    // sluit driver weer af
    driver.quit();
    return "inloggen gelukt";
}