public static String printElements(String phrase[]) {
    String result = "";
    for (int i = 0; i < phrase.length; i++)
    {
        System.out.print(phrase[i] + " ");
        result += phrase[i];     
        if( i != phrase.length - 1)
        {
            result += " ";
        }

    }
        return result;
}