String word = in.next();
     StringBuilder bul = new StringBuilder();
     for (char arg : word.toLowerCase().toCharArray()) {
         switch(arg)
         {
             case 'a': System.out.println("A");break;
             case 'e': System.out.println("E");break;
             case 'i': System.out.println("I");break;
             case 'o': System.out.println("O");break;
             case 'u': System.out.println("U");break;
             default:
                 bul.append(arg);
         }
     }
     System.out.println(bul); //String not Vowels