for (String sTextTime : sListItemTextListBox3) {

            iCountGeo++;

            iAttempts = 0;
            while (iAttempts < 5) {
                try {
                    oList3.selectByVisibleText(sTextTime);
                    break;
                } catch (StaleElementReferenceException e) {
                }
                iAttempts++;
            }
         }