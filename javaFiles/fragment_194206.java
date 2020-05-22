List<Element> list = new ArrayList<>();
try (Stream<String> stream = Files.lines(Paths.get("C:\\Users\\Sean\\Desktop\\elements.csv"))) {

     list = stream.skip(1)
                  .map(line -> {
                      String[] tempArray = line.split(",");
                      Element e = new Element(Integer.parseInt(tempArray[0]),
                              tempArray[1],
                              tempArray[2],
                              Integer.parseInt(tempArray[3]),
                              Integer.parseInt(tempArray[4]),
                              Double.parseDouble(tempArray[5]));
                      return e;
                    }).collect(Collectors.toCollection(ArrayList::new));

} catch (IOException e) {
    e.printStackTrace();
}