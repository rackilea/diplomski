String CurrentData = "";
while((bufferedReader.readLine()) != null) {
    line = CurrentData;
    bw.write(CurrentData);
    ((BufferedWriter) bw).newLine();
}