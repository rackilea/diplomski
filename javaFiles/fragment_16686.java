String prevAmount = headDetails.get("Previous Amount");
Assert.assertNotNull(prevAmount, "Previous Amount found");
//if amount can NOT be negative
Assert.assertTrue(prevAmount.matches("^\\d+\\.\\d{2}$"), "Has 2 precision");
//if amount can be negative
Assert.assertTrue(prevAmount.matches("\\d+\\.\\d{2}$"), "Has 2 precision");