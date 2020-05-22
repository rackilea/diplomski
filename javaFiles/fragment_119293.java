String s = "Hello dilip refer www.google.co.uk www.google.co.in this url www.google.com. hi ramesh this is good for android http://android.com hello there meta.stackoverflow.com";   
       Pattern pc = Pattern.compile("((http://)|(www.))([A-Z,a-z,0-9])+((.com)|(.co.[a-z]{2}))|([A-Z,a-z,0-9].[A-Z,a-z,0-9])+.com");
       Matcher matcher = pc.matcher(s);
       while(matcher.find())
       {
          System.out.println("String Extracted   "+matcher.group());
       }