public class Main {
    public static void main(String[] args) {
        MyFileReader fileReader = new MyFileReader();
        MyFileProcessor fileProcessor = new MyFileProcessor();
        MyFileWriter fileWriter = new MyFileWriter();

        List<String> lines = fileReader.read("input-file.txt");
        List<Info> fileContentAsObjects = fileProcessor.process(lines);

        if (fileContentAsObjects.size() > 0)
        {
            Info singleInfo = fileContentAsObjects.get(0);
            System.out.println(singleInfo);             //if you've overridden toString() ;)

            singleInfo.setName("changedName");          // modify it

            fileContentAsObjects.remove(0);             // get rid of the old one
            fileContentAsObjects.insert(0, singleInfo); // replace it with the same updated one

            fileWriter.write(fileContentAsObjects);     // writes updated info object to file
        }
    }
}