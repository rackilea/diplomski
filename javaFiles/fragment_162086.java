ContentValues cv = new ContentValues();
       cv.put("name", "Cs Tech");
       cv.put("mail", "joe@info.com");         
       cv.put("contact", "180 151 2010");
       cv.put("date", "27 Jul 2011");

       this.db.insert(TABLE_NAME, "name", cv);

       cv.put("name", "Wipro");
       cv.put("mail", "bru@wipro.com");
       cv.put("contact", "180 151 2011");
       cv.put("date", "27 Jul 2011");

       this.db.insert(TABLE_NAME, "name", cv);

       cv.put("name", "TCS");
       cv.put("mail", "jen@tcs.com");  
       cv.put("contact", "180 151 2012");
       cv.put("date", "27 Jul 2011");

       this.db.insert(TABLE_NAME, "name", cv);

       cv.put("name", "Infosys");
       cv.put("mail", "ram@infosys.com");
       cv.put("contact", "180 151 2013");
       cv.put("date", "27 Jul 2011");

       this.db.insert(TABLE_NAME, "name", cv);

       cv.put("name", "Cognizant");
       cv.put("mail", "cts@cts.com");
       cv.put("contact", "180 151 2014");
       cv.put("date", "27 Jul 2011");

       this.db.insert(TABLE_NAME, "name", cv);