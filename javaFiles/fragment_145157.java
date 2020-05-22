try {
            if (driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.abc.rbanking:id/text_logo'][text()='Security Question']")).isDisplayed()) { //case when screen B is displayed Just after screen 1
                MobileElement mfaQ = driver.findElement(By.id("com.abc.rbanking:id/MfaQuestionText"));
                String question = mfaQ.getText();
                String lastword = question.replaceAll("^.*?(\\w+)\\W*$", "$1");
                System.out.println(lastword);
                MobileElement answer = driver.findElement(By.id("com.abc.rbanking:id/MfaAnswerTextBox"));
                answer.sendKeys(lastword);
                MobileElement checkbox = driver.findElement(By.id("com.abc.rbanking:id/ShowChallengeAnswerCheckbox"));
                checkbox.click();
                Thread.sleep(3000);
                MobileElement nextb = driver.findElement(By.id("com.abc.rbanking:id/PrimaryButton"));
                nextb.click();
                Thread.sleep(8000);
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        try

        {
            if (driver.findElement(By.id("com.abc.rbanking:id/WhatsNew")).isDisplayed()) { //case when screen A is displayed after screen B
                MobileElement cross = driver.findElement(By.xpath("//*[@class = 'android.widget.ImageView']"));
                cross.click();
                Thread.sleep(3000);
            }
        } catch (
                Exception e)

        {
            e.printStackTrace();
        }
    }