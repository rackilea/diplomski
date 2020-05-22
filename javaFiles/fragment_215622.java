public static void main (String[] args) throws java.lang.Exception
    {
        Pattern p = Pattern.compile( "\\[(.*)\\]\\((.*)\\)");
        String input = "I got  some [text](link) here";
        Matcher m = p.matcher( input );
        if( m.find() )
        {
            String found_text =  m.group(1);
            String found_link =  m.group(2);
            String replaceWith = "<a href=" + "\"" + found_link + "\"" + ">" + found_text + "</a>" ;
            input = input.replaceAll("\\[(.*)\\]\\((.*)\\)", replaceWith );
            System.out.println( input );
        }
    }