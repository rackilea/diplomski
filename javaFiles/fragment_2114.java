public static void main(String[] args) {
    try {
        String filePath = getFilePath(args);
        AtomicReference<String> content = new AtomicReference<String>();
        content.set(readYamlFile(sourceFilePath));
        jsonStr = convert(content.toString());
    }  catch (FileNotFoundException e) {
        System.out.println("not found");
    } catch (ReadYamlFileException e) {
        System.out.println("Not able to load file");
    } catch (ConvertJsonExceptione) {
        System.out.println("Conversion failed ");
    }
}

private String readYamlFile(String) throws ReadYamlFileException{ ... }
private String convert(String) throws ConvertJsonException{ ... }