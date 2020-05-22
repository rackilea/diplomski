public class Chatbot {


    public Chatbot( )
    {
    }

    /*
     * Generates a variety of responses, based on what the user has stated
     */
    public void respond( String statement )
    {        
        // use the findKeyword method to check for various cases of user statements
        if( statement.length() == 0 )
        {
            System.out.println( "Please say something :)" );
        }

        else if( findKeyword( statement, "hi" ) > 0 ||
            findKeyword( statement, "hello" ) > 0 ||
            findKeyword( statement, "hey" ) > 0 ||
            findKeyword( statement, "hiya" ) > 0 ||
            findKeyword( statement, "heya" ) > 0 )
            {
                System.out.println( "Hello to you too!" );
            }

        else if( findKeyword( statement, "how are you" ) > 0 ||
                 findKeyword( statement, "hows it going" ) > 0 ||
                 findKeyword( statement, "howre you" ) > 0 ||
                 findKeyword( statement, "how ya doing" ) > 0 ||
                 findKeyword( statement, "yo wassup" ) > 0 ||
                 findKeyword( statement, "hey whats up" ) > 0 || 
                 findKeyword( statement, "whats up" ) > 0 )
            {
                System.out.println( "I'm good, how are you?" );
            }
    }



    /*
     * findKeyword method, returns either a 0 or a 1
     * @ 0 -- keyword not found
     * @ 1 -- keyword found
     */
    public int findKeyword( String statement, String keyword )
    {

                // This is in case the keyword is not in the statement at all
        if( !statement.contains( keyword ) )
        {
            return 0;
        }


        int position = statement.toLowerCase().indexOf( keyword.toLowerCase() );        // position of the keyword in the statement
        statement = " " + statement.toLowerCase().replaceAll( "\'\",.?", "") + " ";                   // the purpose of this statement is to allow for us to search for specific phrases w/ spaces before and after the keyword

        String sub = statement.substring( position, position + keyword.length() + 2 );  // isolates the keyword with 1 character before and after

        String charBeforeKeyword = sub.substring( 0, 1 );                               // the character before the keyword
        String charAfterKeyword = sub.substring( sub.length() - 1, sub.length());      // the character after the keyword



        /*
         * Now, we check to see if the characters we isolated before are letters; if they are        * 
         * @ If they are letters...then our keyword is part of a bigger word (e.g. if we searched for "success" and it brought us "successful"
         * @ If they are not letters, then we have found our keyword with punctuation and/or spaces before/after it
         */
        if( (charBeforeKeyword.compareTo( "a" ) < 0 || charBeforeKeyword.compareTo( "z" ) > 0 )
                && (charAfterKeyword.compareTo( "a" ) < 0 || charAfterKeyword.compareTo( "z" ) > 0 ))
        {
            return 1;
        }

        return 0;  

    }


}