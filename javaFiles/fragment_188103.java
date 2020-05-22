public void testIdenticalAndSimilar() throws Exception {
   String controlXML = "<account><id>3A-00</id><name>acme</name></account>";
   String testXML = "<account><name>acme</name><id>3A-00</id></account>"; 
   Diff diff = new Diff(controlXML, testXML);
   assertTrue(diff.similar());
   assertFalse(diff.identical());
}