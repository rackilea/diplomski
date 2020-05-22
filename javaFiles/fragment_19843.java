public class RemDup
{
        public static void main ( String[] args )
        {
            String sentence = "this is java programming program progress";
            int max_word_length = sentence.length()/2;
            int min_word_length = 2;
            while(max_word_length>=min_word_length)
            {
            int si = 0;
            int ei = max_word_length;
            while ( ei<sentence.length() )
            {
                int e=ei;
                while ( e<sentence.length() )
                {
                    int ind = sentence.indexOf ( sentence.substring ( si, ei ),e );
                    if ( ind!=-1 )
                    {
                        if(
                         sentence.substring(ind-1,ind).equals(" ")
                        &((ind+max_word_length)>=sentence.length()||
                        sentence.substring(ind+max_word_length,ind+max_word_length+1).equals(" "))
                        )
                        {
                        sentence = sentence.substring ( 0,ind ) +sentence.substring ( ind+max_word_length,sentence.length() );
                        }
                        e=ind+max_word_length;

                    }
                    else break;
                }


                si+=1;
                ei+=1;

            }
            max_word_length--;
            }
            System.out.println(sentence);
        }

}