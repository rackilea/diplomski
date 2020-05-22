String lang= //... here I assigned "English" while I thought
             //    I was assigning it "en"
Locale locale=new Locale(lang);
Locale.setDefault(locale);       // (*)

// and later
Locale.getLocale().getLanguage();   //returns "english"