private static String encrypt(String str){
    String string = str.toLowerCase();
    for(int i = 0; i < string.length(); i++)
    {
        char ch = string.charAt(i);

        switch(ch)
        {
            case 'h':
            {
                string = string.substring(0,i)+"l"+string.substring(i+1);
                break;
            }
            case 'i':
            {
                string = string.substring(0,i)+"p"+string.substring(i+1);
                break;
            }
            default:
            {
                System.out.println("Enter a-z");
                break;
            }
        }

    }
    return string;
}