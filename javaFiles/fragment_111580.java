public void selectFromDropdown(String option) {

        WebElement dobFieldDropdown;

        WebElement content = driver.findElement(By.className("leftClmn"));

        driver.findElement(By.id("aWrapper_dob_day")).click();

        dobFieldDropdown = content.findElements(By.className("tooltipGroup")).get(2).findElement(By.className("day")).findElement(By.tagName("ul"));

        HashMap<String, WebElement> dropdownValues = new HashMap<String, WebElement>();

        for (WebElement el : dobFieldDropdown.findElements(By.tagName("a"))) {
            dropdownValues.put(el.getText(), el);

            System.out.println(el.getText().toString());
        }
        dropdownValues.get(option).click();

    }