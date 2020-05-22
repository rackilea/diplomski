StringBuffer s = new StringBuffer("this\nis\nsome\ntext");
        String word = ""; 
        for(int i = s.length() - 1; i >= 0; --i)
        {
            if(s.charAt(i) != '\n')
            {
                word = s.charAt(i) + word;
            }
            else{
                System.out.println(word);
                word = "";
            }
        }
        if(!word.equals(""))
            System.out.println(word);