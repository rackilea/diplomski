String a = "שְׁ";  //U+05E9 + U+05B0 + U+05C1
String b = "שְׁ";  //U+05E9 + U+05C1 + U+05B0

String nomrA = java.text.Normalizer.normalize(a, java.text.Normalizer.Form.NFC);
String nomrB = java.text.Normalizer.normalize(b, java.text.Normalizer.Form.NFC);

assertFalse("Original strings are not equal.", a.equals(b));
assertTrue("Normalized strings are equal.", normA.equals(normB));