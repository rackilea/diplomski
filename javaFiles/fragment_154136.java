Locale loc = new Locale("en","UK"); // test code

if(loc.getCountry().equals("UK")){
    loc = new Locale(loc.getLanguage(), "GB");
    }
Currency cur = Currency.getInstance(loc);