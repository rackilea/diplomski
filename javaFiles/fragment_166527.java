String holdText = outputarea.getText();
try (PrintWriter w = new PrintWriter(new File(filename));
     BufferedReader br = new BufferedReader(new StringReader(holdText))) {
    while ((holdText = br.readLine()) != null) {
        w.println(holdText);
    }

} catch (Exception e) {
        System.out.println("File not found");
}