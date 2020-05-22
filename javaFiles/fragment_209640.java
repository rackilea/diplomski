while(s.length()>0) // this is an infinite loop, since s never changes
    {
        index = s.indexOf(' '); // this will always return the index of the first empty 
                                // space or -1 if there are no spaces at all
                                // use index = s.indexOf(' ',c);
        part = s.substring(c,index); // will fail if index is -1
        part = part.trim();
        ch  = part.charAt(0); // will throw an exception if part is an empty String
        String s1 = String.valueOf(ch);
        modif = modif+ s1.toUpperCase()+".";
        c = index ; // this should be c = index + 1
    }