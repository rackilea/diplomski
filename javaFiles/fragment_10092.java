// To write...
BufferedWriter bw = null;
try {
    bw = new BufferedWriter(new FileWriter(new File("MyJson.txt")));
    bw.write(myObjectJson);
} finally {
    try {
        bw.close();
    } catch (Exception e) {
    }
}

// To Read
BufferedReader br = null;
try {
    br = new BufferedReader(new FileWriter(new File("MyJson.txt")));
    myObjectJson = br.readLine();
} finally {
    try {
        br.close();
    } catch (Exception e) {
    }
}