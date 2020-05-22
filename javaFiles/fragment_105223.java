public static void copearCaracteres(char[] arrayOriginal )
{
    String cadena = new String("OPERATIVO");
    int div = arrayOriginal.length / cadena.length();
    int j = div * cadena.length();

    for(int i=0 ; i < arrayOriginal.length; i++)
    {
        if(i == j) return;
        arrayOriginal[i] = cadena.charAt(i % cadena.length());
    }
}