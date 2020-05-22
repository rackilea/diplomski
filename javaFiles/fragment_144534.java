int[] wordFrequency = new int[global_dict_list.size()];

for ( String globalWord : global_dict_list )
{
    for ( int i = 0; i < words.length; i++ ) 
    {
         if ( words[i].equals(globalWord) ) 
         {
             wordFrequency[i]++;
         }
    }
}