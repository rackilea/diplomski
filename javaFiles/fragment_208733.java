Scanner inputReader = new Scanner (System.in);
    char result='y';
    while(result == 'y')
    {
        // ’Nytto’-kod:
        int vowels_count = 0;
        int consonents_count = 0;
        int charachters_count= 0;
        System.out.println("Skriv in en text");
        String str = inputReader.nextLine();
        String str2 = str.toLowerCase();
        char[] chr = str2.toCharArray();

        for(int i=0;i<chr.length;i++)
        {
            if(chr[i] == 'a' || chr[i]== 'e' || chr[i] == 'i' || chr[i] == 'o' || chr[i] == 'u')
                vowels_count++;
            else if(chr[i] == '-' || chr[i] == '!' || chr[i] == '?' || chr[i] == ',' || chr[i] == '.' || chr[i] == ':' || chr[i] == ';')
                charachters_count++;
            else
                consonents_count++;
        }

        System.out.println("Antalet vokaler:"+vowels_count+ " "+"Antalet konsonanter:"+consonents_count+" "+"Antalet interpunktionstecken:"+charachters_count++);
        //wrap your play again logic in another do/while where you
        // ask for y or n until they enter either one
        do {
            System.out.println ("För att upprepa: Skriv y");
            System.out.println ("För att avsluta: Skriv n");
            String repeat=inputReader.nextLine();//read the entire next line <----
            result=repeat.charAt(0);
            if(result=='y')
            {
                continue;
            }
            else if(result !='y' && result !='n')
            {
                System.out.println("Du får bara skriva y eller n, försök igen!");
            }
            else
            {
                System.out.println ("Klart.");
                inputReader.close ();
            }
        } while (result !='y' && result !='n');
    }