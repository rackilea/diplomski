private static BufferedReader buf1;

public static void main(String[] args) throws IOException {
    //some code
    try (BufferedReader buf2 = buf1)
    {

    } 
}