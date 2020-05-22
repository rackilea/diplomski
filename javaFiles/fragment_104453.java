locale = new Locale("el_GR");
Log.d(TAG, String.format("[el_GR] Language: '%s' ~ Country: '%s'", locale.getLanguage(), locale.getCountry()));

locale = new Locale("el", "GR");
Log.d(TAG, String.format("[el, GR] Language: '%s' ~ Country: '%s'", locale.getLanguage(), locale.getCountry()));

locale = Locale.getDefault(); //Device with el_GR language
Log.d(TAG, String.format("[default] Language: '%s' ~ Country: '%s'", locale.getLanguage(), locale.getCountry()));