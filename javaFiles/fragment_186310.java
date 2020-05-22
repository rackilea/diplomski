WebElement element = driver.findElement(By.cssSelector("#page0002_para27"));

public static String geNodeText(WebElement element) {
        String text = element.getText();
        for (WebElement child : element.findElements(By.xpath("./*"))) {
          text = text.replaceFirst(child.getText(), "");
        }

        return text;
      }