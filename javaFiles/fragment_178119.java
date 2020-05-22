public void formatTxtFile() throws InterruptedException {
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(":");
            System.out.println(parts[0] + " " +parts[1]);
            Thread.sleep(1000);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}