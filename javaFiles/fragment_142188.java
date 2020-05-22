String[] array = { "<h1> i love india <\h1>",
                           "<xyz> name <\xyz>",
                           "<html> hey i won! <\html>",
                           "<syd> like i`enter code here`t <\syd>"
                        };
    Pattern pattern = Pattern.compile(">((.[^><]+))<");
    for (String str : array ) {
        Matcher m = pattern.matcher(str);
        if(m.find()) 
          System.out.println(m.group(1));
        else
          System.out.println("none");
    }