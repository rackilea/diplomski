while (!phrase.equals("quit")){

        for (i = 0; i < length; i++){
            ch = phrase.charAt(i);
            if (ch == (' '))
                countBlank++;
            switch (ch)
            {
            case 'a': case 'A':  countA++; break;
            case 'e': case 'E':  countE++; break;
            case 's': case 'S':  countS++; break;
            case 't': case 'T':  countT++; break;       
            }
        }
        System.out.println ();
        System.out.println ("Number of blank spaces: " + countBlank);
        System.out.println ();
        System.out.println ("Number of a's: " +countA);
        System.out.println ("Number of e's: " +countE);
        System.out.println ("Number of s's: " +countS);
        System.out.println ("Number of t's: " +countT);
        phrase =scan.nextLine(); //read next phrase from user to continue.
        }