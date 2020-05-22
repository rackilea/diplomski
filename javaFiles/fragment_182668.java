HashMap<String, Integer> tapObject = new HashMap<String, Integer>();

        tapObject.put("x", 100); // in pixels from left

        tapObject.put("y", 300); // in pixels from top

        driver.executeScript("mobile: tap", tapObject);