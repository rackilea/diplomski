@Test
public void testParsingForCommas() {
   StringToTransaction tested = new StringToTransaction();
   List<String> expected = new ArrayList<String>();
   // Add expected strings list here..

   List<String> actual = Deencapsulation.invoke(tested, "parseTransactionString", "blah blah");
   assertEquals(expected, actual);
}