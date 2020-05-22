// wait for a new window and switch to it
driver.switchTo().window(wait.until(new ExpectedCondition<String>() {
    @Override
    public String apply(WebDriver drv) {
        for (String handle : drv.getWindowHandles()){
            if (!handle.equals(mainHandle))
                return handle;
        }
        return null;
    }
}));