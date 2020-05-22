public class DrawerMenuTest {
    AndroidDriver<WebElement> driver;

    @Test(priority = 1)
    public void DrawerMenuIcon() {
        //get driver instance first
        driver = DriverInit.getInstance().getDriver();

        WebElement drawerMenu = driver.findElement(By
                .id("com.movocado.socialbostonsports:id/rel_drawer"));
        try {
            drawerMenu.click();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }
}