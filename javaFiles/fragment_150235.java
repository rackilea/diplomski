String result = null;
try {
    Runtime r = Runtime.getRuntime();                    

    Process p = r.exec("example.bat");

    BufferedReader in =
        new BufferedReader(new InputStreamReader(p.getInputStream()));
    String inputLine;
    while ((inputLine = in.readLine()) != null) {
        System.out.println(inputLine);
        result += inputLine;
    }
    in.close();

} catch (IOException e) {
    System.out.println(e);
}