List<WebElement> linkList = driver.findElements(By.cssSelector("a[class^='btn btn-sm']"));
        List<Integer> idListFromLink = new ArrayList<Integer>();
        for(WebElement link : linkList){
            String [] temp = link.getAttribute("href").split("=");
            int id = Integer.valueOf(temp[temp.length - 1]);
            idListFromLink.add(id);
        }