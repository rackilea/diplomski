int c;
FileReader fr = new FileReader("text.txt");
while(true){
    c = fr.read();
    if (c == 32)
        break;
    System.out.println((char)c);
    }