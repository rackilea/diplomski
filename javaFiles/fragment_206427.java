List<WebElement> linkList = driver.findElements(By.cssSelector("a[class^='btn btn-sm']"));
            int listSize = linkList.size();
            int [] idListFromLink = new int[listSize];
            for(int i = 0; i < listSize; i++){
                String [] temp = linkList.get(i).getAttribute("href").split("=");   //split the href value using delimeter '='
                int id = Integer.valueOf(temp[temp.length - 1]); //get the last item
                idListFromLink[i] = id;
            }