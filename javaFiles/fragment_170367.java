private static final Item ITEM_4 = 
  Item.builder()
        .dogCat("bow|meow")
        .dog("bow")
        .cat("meow")
        .build();

private static final Item ITEM_5 = 
  Item.builder()
        .dogCat("bow|meow")
        .dog("bow")
        .cat("whoop")
        .build();

    @Test
    public void testIfDogCatMatchesConcatenatedDogCat() {
        boolean actualValue = itemValidator.isValid(ITEM_4);
        Assert.assertTrue(actualValue);
    }

    @Test
    public void testIfDogCatDoesNotMatchesConcatenatedDogCat() {
        boolean actualValue = itemValidator.isValid(ITEM_5);
        Assert.assertFalse(actualValue);
    }