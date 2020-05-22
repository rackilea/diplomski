public String loader(String FilePath) {

    String str = null;
    StringBuilder strb = new StringBuilder();
    // the following line means the try block takes care of closing the resource
    try (BufferedReader br = new BufferedReader(new FileReader(FilePath))) {
        while ((str = br.readLine()) != null) {
            strb.append(str).append("\n");
        }
    } catch (FileNotFoundException f) {
        System.out.println(FilePath + " does not exist");
        return null;
    } catch (IOException e) {
        e.printStackTrace();
    }
    return strb.toString();
}