@Test
public void testFindOptionByIgnoreCaseText() {
    final WebElement peterOption = mockOption("Peter");
    final WebElement stephaneOption = mockOption("Stephane");
    final WebElement noelOption = mockOption("Noël");
    final WebElement katyOption = mockOption("Céline");
    final WebElement bradOption = mockOption("Brad ");
    final WebElement pierreOption = mockOption(" Pierre");
    final List<WebElement> options = Arrays.asList(peterOption, stephaneOption, noelOption, katyOption, bradOption, pierreOption);

    final WebElement element = Mockito.mock(WebElement.class);
    Mockito.when(element.getTagName()).thenReturn("select");
    Mockito.when(element.findElements(By.tagName("option"))).thenReturn(options);
    Select select = new Select(element);

    Assert.assertEquals("OK", 0, step.findOptionByIgnoreCaseText("Peter", select));

    Assert.assertEquals("OK", 1, step.findOptionByIgnoreCaseText("Stephane", select));
    Assert.assertEquals("OK", 1, step.findOptionByIgnoreCaseText(" Stephane", select));
    Assert.assertEquals("OK", 1, step.findOptionByIgnoreCaseText("Stephane ", select));
    Assert.assertEquals("OK", 1, step.findOptionByIgnoreCaseText("Stéphane", select));

    Assert.assertEquals("OK", 2, step.findOptionByIgnoreCaseText("Noël", select));
    Assert.assertEquals("OK", 2, step.findOptionByIgnoreCaseText("Noel", select));

    Assert.assertEquals("OK", 3, step.findOptionByIgnoreCaseText("Celine", select));
    Assert.assertEquals("OK", 3, step.findOptionByIgnoreCaseText("Céline", select));

    Assert.assertEquals("OK", 4, step.findOptionByIgnoreCaseText("Brad", select));
    Assert.assertEquals("OK", 4, step.findOptionByIgnoreCaseText(" Brad", select));
    Assert.assertEquals("OK", 4, step.findOptionByIgnoreCaseText("Brad ", select));
    Assert.assertEquals("OK", 4, step.findOptionByIgnoreCaseText(" Brad ", select));

    Assert.assertEquals("OK", 5, step.findOptionByIgnoreCaseText("Pierre", select));
    Assert.assertEquals("OK", 5, step.findOptionByIgnoreCaseText(" Pierre", select));
    Assert.assertEquals("OK", 5, step.findOptionByIgnoreCaseText("Pierre ", select));
    Assert.assertEquals("OK", 5, step.findOptionByIgnoreCaseText(" Pierre ", select));
}

private WebElement mockOption(String name) {
    final WebElement option = Mockito.mock(WebElement.class, name);
    Mockito.when(option.getText()).thenReturn(name);
    return option;
}