public class Test
{

    public static void main ( String [ ] args )
    {
        String original = "balloonnnnns";
        int length = original.length ( );
        int count = 1;
        String altered = "";
        //Loop over all string
        for(int i = 0; i < (length-1); i++ ){
            //while they are the same
            while (original.charAt(i) == original.charAt(i + 1)){
                //count and keep going on the original string
                count++;
                i++;
                //avoid border case when last character is repeated, i.e : baaaaaaaa
                if ( i == length -1)
                {
                    break;
                }
            }
            //if they are repetead
            if(count > 1)
            {
                //add altered + count + charRepeated, i.e. a3e5t
               altered = altered +count + original.charAt(i);

            }
            else{
                //just add the normal character without count
                altered += original.charAt(i);
            }
            //add last character if not repeated
            if ( (i == length - 2) && (count > 1))
            {
                altered += original.charAt ( i+1 );
            }

            //reset counting 
            count = 1;

        }
        System.out.println ( altered );
    }
}