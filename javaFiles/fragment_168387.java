public class Main
{
    public static void main (String [] args)
    {
        String [] array = new String []
        {
                "My name is Fouad *6,#%$       , 67655-76       ",
                "My name is Fouad *7,#%$       , 67655-77       ",
                "My name is Fouad *8,#%$       , 67655-78       ",
                "My name is Fouad *9,#%$       , 67655-79       ",
                "My name is Fouad *0,#%$       , 67655-70       ",
                "My name is Fouad *1,#%$       , 67655-71       "
        };

        String [] names = new String [array.length];
        String [] phones = new String [array.length];

        for (int i = 0; i < array.length; i++)
        {
            names [i] = array [i].substring (0, 30).trim ();
            phones [i] = array [i].substring (31).trim ();
        }

        for (String name : names) System.out.println (name);
        for (String phone : phones) System.out.println (phone);
    }
}