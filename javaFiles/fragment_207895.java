String base = driver.getWindowHandle();

    Set <String> set = driver.getWindowHandles();

    set.remove(base);
    assert set.size()==1;

    driver.switchTo().window(set.toArray(new String[0]));

    driver.close();
    driver.switchTo().window(base);