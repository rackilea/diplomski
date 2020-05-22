String logo = xp.evaluate("//LogoTopLeft/text()", doc);
String signIn = xp.evaluate("//SignInLink/text()", doc);
String signUp = xp.evaluate("//SignUpLink/text()", doc);

System.out.println( "logo = " + logo +
                    "; signIn = " + signIn +
                    "; signUp = " + signUp);
/* prints:
   logo = //*[@id='corp_logo']; signIn = //*[@id='login']; signUp = //*[@id='signup']
*/