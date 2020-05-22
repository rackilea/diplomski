public static void main(String[] args) throws Exception {
    test("aaa", "bbb");
}

public static void test(String DATA1, String DATA2) throws IOException {
    String file = "data.txt";
    String newFile = "dataNew.txt";

    String CurrentLine = "";
    BufferedReader br = new BufferedReader(new FileReader(file));
    while ((CurrentLine = br.readLine()) != null) {

        String[] modify = CurrentLine.split(", ");
        String data1 = modify[0];
        String data2 = modify[1];
        String data3 = modify[2];
        String data4 = modify[3];

        BufferedWriter bw = new BufferedWriter(new FileWriter(newFile, true));

        if (!data1.contains(DATA1)) {
            StringBuilder sb = new StringBuilder();
            sb.append(CurrentLine.replace(data1, DATA1));
            sb.append("\n");

            while ((CurrentLine = br.readLine()) != null) {
                sb.append(CurrentLine);
                sb.append("\n");
            }

            bw.write(sb.toString());

            File RESIDENTS_OLDDETAILS = new File(file);
            RESIDENTS_OLDDETAILS.delete();

            File RESIDENTS_NEWDETAILS = new File(newFile);
            RESIDENTS_NEWDETAILS.renameTo(RESIDENTS_OLDDETAILS);

            br.close();
            bw.close();
            break;
        }
    }
}