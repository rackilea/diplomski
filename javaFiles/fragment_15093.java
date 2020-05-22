String pattern = "\\+.*";
    String input = "paramA +paramB";
    String input2 = "+paramA +paramB";

    Assert.assertFalse(input.matches(pattern));  // False
    Assert.assertTrue(input2.matches(pattern));  // True