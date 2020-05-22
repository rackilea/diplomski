/**
 * 
 * @return true if driver is alive else false
 */
public Boolean isAlive() {
    try {
        driver.getCurrentUrl();//or driver.getTitle();
        return true;
    } catch (Exception ex) {
        return false;
    }
}