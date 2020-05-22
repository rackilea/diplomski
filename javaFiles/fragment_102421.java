String cyrillic_letter_i = "\u0418";
String encoded = URLEncoder.encode(cyrillic_letter_i, "UTF-8");
String google = "https://www.google.ch/search?q="
              + encoded
              + "&hl=de&client=firefox-a&hs=hzU&rl......";
URI uri = URI.create(google);
Desktop.getDesktop().browse(uri);