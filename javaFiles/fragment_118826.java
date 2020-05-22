for (String sTextProduct : sListItemTextListBox4) {

                iAttempts = 0;
                while (iAttempts < 5) {
                    try {
                        oList4 = new Select(dev.findElement(By.id("tool4"))); //here
                        oList4.selectByVisibleText(sTextProduct);
                        break;
                    } catch (StaleElementReferenceException e) {
                    }
                    iAttempts++;
                }