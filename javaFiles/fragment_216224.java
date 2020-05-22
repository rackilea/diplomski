try (BufferedReader br = new BufferedReader(
        new InputStreamReader(new FileInputStream(CookCoutyOut1)))) {
    String line;
    while ((line = br.readLine()) != null) {
        line1 += line + "\n";
    }
}