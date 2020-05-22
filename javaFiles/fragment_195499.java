// http://code.google.com/p/android/issues/detail?id=38622
    public void test_getSymbol_38622() throws Exception {
        // The CLDR data had the Portuguese symbol for "EUR" in pt, not in pt_PT.
        // We weren't falling back from pt_PT to pt, so we didn't find it and would
        // default to U+00A4 CURRENCY SIGN (¤) rather than €.
        Locale pt_BR = new Locale("pt", "BR");
        Locale pt_PT = new Locale("pt", "PT");
        assertEquals("R$", Currency.getInstance(pt_BR).getSymbol(pt_BR));
        assertEquals("BR$", Currency.getInstance(pt_BR).getSymbol(pt_PT));
        assertEquals("€", Currency.getInstance(pt_PT).getSymbol(pt_BR));
        assertEquals("€", Currency.getInstance(pt_PT).getSymbol(pt_PT));
    }