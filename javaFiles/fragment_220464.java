try {
    String fn = getExternalFilesDir(null) + File.separator + "android.txt";
    BufferedWriter bw = new BufferedWriter(new FileWriter(fn, true));
    bw.write("\nIt is awesome\n");
    bw.close();

    // checking
    BufferedReader br = new BufferedReader(new FileReader(fn));
    String line;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }
    br.close();
} catch (IOException e) {
    e.printStackTrace();
}