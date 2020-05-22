protected WordStore(String file) throws IOException {
 //doing something that can throw an IOException
}

//Caller handles it
try {
    new WordStore("text.txt");
} catch (IOException ioex) {
    //Handle the exception
}

//Or the caller (Assuming the caller is the main method) can throw it back
public static void main(String[] args) throws IOException {
    new WordStore("text.txt");
}