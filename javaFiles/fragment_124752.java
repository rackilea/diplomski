public String readDoc(File f) {
String text = "";
int read, N = 1024 * 1024;
char[] buffer = new char[N];

try {
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);

    while(true) {
        read = br.read(buffer, 0, N);
        text += new String(buffer, 0, read);

        if(read < N) {
            break;
        }
    }
} catch(Exception ex) {
    ex.printStackTrace();
}

return text;
}