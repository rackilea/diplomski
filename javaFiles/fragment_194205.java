try (Scanner reader = new Scanner(new File("C:\\Users\\Sean\\Desktop\\elements.csv"))) {
        reader.nextLine();
        while (reader.hasNextLine()){
                String[] tempArray = reader.nextLine().split(",");
                Element e = new Element(Integer.parseInt(tempArray[0]), 
                                        tempArray[1], 
                                        tempArray[2],
                                        Integer.parseInt(tempArray[3]),
                                        Integer.parseInt(tempArray[4]),
                                        Double.parseDouble(tempArray[5]));
                list.add(e);
        }

} catch (IOException e) {
       e.printStackTrace();
}