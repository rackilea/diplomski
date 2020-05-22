public class ReadFromFile implements Callable<List<String>> {

  private File file;

  public ReadFromFile(File file) {
    this.file = file;
  }

  @Override
  public List<String> call() throws Exception {
    String row = null;

    List<String> data = new ArrayList<>();
    try (BufferedReader csvReader = new BufferedReader(new FileReader(file))) {
      while ((row = csvReader.readLine()) != null) {
        data.addAll(Arrays.asList(row.split(";")));
      }
    } catch (IOException i) {
      System.out.println(i.getMessage());
    }

    return data;
  }
}