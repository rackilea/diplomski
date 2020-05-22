String arr1[];
String arr2[];
String arr3[];
String arr4[];
try {
        BufferedReader in = new BufferedReader(new FileReader("infilename"));
        String str;
        str = in.readLine();
        arr1[] = str.split(" ");
        str = in.readLine();
        arr2[] = str.split(" ");
        str = in.readLine();
        arr3[] = str.split(" ");
        str = in.readLine();
        arr4[] = str.split(" ");

        in.close();
    } catch (IOException e) {
    }