List<WebElement> allImages = driver.findElements(By.tagName("img"));
System.out.println("All images #: " + allImages.size());

List<WebElement> imagesWithDataAtf = allImages
        .stream()
        .filter(image -> image.getAttribute("data-atf") != null)
        .collect(Collectors.toList());

System.out.println("Images with data-atf attribute #: " + imagesWithDataAtf.size());