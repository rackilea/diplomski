public static void main(String[] args)
{
    System.out.println("Arg 1 = " + args[0] + "\nStdin = ");
    try (InputStreamReader isr = new InputStreamReader(System.in)) {
        int ch;
        while((ch = isr.read()) != -1)
            System.out.print((char)ch);
    }catch(IOException e) {
        e.printStackTrace();
    }
}