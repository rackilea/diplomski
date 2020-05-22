public static void main(String[] args) throws IOException
{
    while(true) {
        try
        {
            mySocket = new Socket("localhost", 6789);
            myReader = new BufferedReader(new InputStreamReader(System.in));
        }
        ...
        ...
    }
}