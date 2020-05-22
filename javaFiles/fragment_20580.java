BufferedReader in = null;
try{
    Process p = Runtime.getRuntime().exec("ipconfig");
    InputStream s = p.getInputStream();

    in = new BufferedReader(new InputStreamReader(s));
    String temp;

    while ((temp = in.readLine()) != null) {
        System.out.println(temp);
    }
} catch (Exception e){
    e.printStackTrace();
} finally {
    if (in != null) in.close();
}