public static void doIt(BufferedReader r, PrintWriter w) throws IOException {

String newString;
LinkedList<String> list = new LinkedList<String>();
int i = 0;
while ((newString = r.readLine()) != null) {
    if (i < 50) {
        i++;
        list.addFirst(newString);
    } else {
        for (String s : list)
            w.println(s);
        list.clear();
        list.addFirst(newString); // <---- add this line and you should be fine
        i = 0;
    }
}

for (String s : list)
    w.println(s);

}