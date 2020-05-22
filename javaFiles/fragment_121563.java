Document doc = Jsoup
   .connect("http://services2.hdb.gov.sg/webapp/BB33RTIS/BB33SSearchWidget")
   .timeout(10000) // edit: set timeout to 10 seconds
   .data("FLAT_TYPE", "02")
   .data("NME_NEWTOWN", "BD      Bedok")
   .data("NME_STREET", "")
   .data("NUM_BLK_FROM", "")
   .data("NUM_BLK_TO", "")
   .data("dteRange", "12")
   .data("DTE_APPROVAL_FROM", "Apr 2015")
   .data("DTE_APPROVAL_TO", "Apr 2016")
   .data("AMT_RESALE_PRICE_FROM", "")
   .data("AMT_RESALE_PRICE_TO", "")
   .data("Process", "continue")
   .cookies(cookies)
   .post();