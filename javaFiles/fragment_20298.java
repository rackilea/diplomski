public static void main(String[] args)
{
  Scanner kb = new Scanner(System.in);
        r r = new r();
        System.out.println(r.func(3));
}

  public static String func(int size)
  {
     String value = "";
     if(size == 1)
        return "?";
     else {
        for (int i = 1; i < size; i++){
        value += "?,";
        }

        value+= "?";
        return value;
}