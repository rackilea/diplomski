public String readLine(BufferedReader br){
    String rl = br.readLine();
    if (rl.trim().length() > 2) {
        return rl;
    }else return readLine(br);
}