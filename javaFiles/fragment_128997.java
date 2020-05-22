Process hostname = Runtime.getRuntime().exec("hostname");

BufferedReader stdInput = new BufferedReader(new
            InputStreamReader(hostname.getInputStream()));
String s;
while ((s = stdInput.readLine()) != null) {
        System.out.println(s);
}