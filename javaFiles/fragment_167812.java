public class Song 
{

    private String notes;

    public Song(String music) 
    {
        notes = music;
        char[] store = new char[notes.length()];
        int actualLetter=0;
        //loop for consuming the letters
        for (int i = 0; i < notes.length(); ++i) 
        {
            if(Character.isLetter(notes.charAt(i)))
            {
                //converts a letter to uppercase
            store[i] = Character.toUpperCase(notes.charAt(i));

            }
        }
        //a valid array that is one dimensional
        char[] valid = {'D','R','M','F','S','L','T'};





            //looping for getting the actual size of clean
            for (int i = 0; i < store.length; ++i) 
            {
                for(int j=0;j<valid.length;++j)
                if (store[i] == valid[j]) 
                {
                    actualLetter++;
                }
            }
            char[] clean = new char[actualLetter];
            int a=0;
             //loop for getting equivalent letters
            for (int i = 0; i < store.length; ++i) 
            {
                for(int j=0;j<valid.length;++j)
                if (store[i] == valid[j]) 
                {
                    clean[a]=store[i];
                    a++;
                }
            }
            // output the values
        for(char clense:clean)
        {
            System.out.println(clense);
        }
    }
}