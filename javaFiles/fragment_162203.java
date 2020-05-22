try {
    Process p = Runtime.getRuntime().exec(new String[] { "cmd", "/c", "echo", "This", "is", "an", "argument",
            "&&", "echo", "this", "command", "snuck", "in" });
    BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
    String s;
    while ((s = reader.readLine()) != null) {
        System.out.println(s);
    }
} catch (IOException e) {
    e.printStackTrace();
}