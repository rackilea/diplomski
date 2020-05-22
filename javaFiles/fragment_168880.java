String htmlFragment =
   "<img onerror=\"img_onerror(this);\" data-logit=\"true\" data-pid=\"MOBDDDBRHVWQZHYY\"\n" + 
   "   data-imagesize=\"thumb\"\n" + 
   "   data-error-url=\"http://img1a.flixcart.com/mob/thumb/mobile.jpg\"\n" + 
   "   src=\"http://img8a.flixcart.com/image/mobile/h/y/y/samsung-galaxy-s-duos-s7562-125x125-imadddczzr4qhqnc.jpeg\"\n" + 
   "   alt=\"Samsung Galaxy S Duos S7562: Mobile\"\n" + 
   "   title=\"Samsung Galaxy S Duos S7562: Mobile\"></img></a>";
Pattern pattern =
   Pattern.compile( "(?m)(?s)<img\\s+(.*)src\\s*=\\s*\"([^\"]+)\"(.*)" );
Matcher matcher = pattern.matcher( htmlFragment );
if( matcher.matches()) {
   System.err.println(
      "OK:\n" +
      "1: '" + matcher.group(1) + "'\n" +
      "2: '" + matcher.group(2) + "'\n" +
      "3: '" + matcher.group(3) + "'\n" );
}