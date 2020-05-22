public static void main(String[] args) throws IOException 
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.close();

    // Will throw IOException
    int i = System.in.read();
}