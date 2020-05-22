new WebDriverWait(driver, 10)
        .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("tr[row]")))
        .forEach(row -> {
            String replica = row.findElement(By.cssSelector("td[title='Replica']")).getText().trim();
            String queueSize = row.findElement(By.cssSelector("td[title='Queue size']")).getText().trim();
            System.out.println(String.format("%s %s", replica, queueSize));
        });