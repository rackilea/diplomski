File newFile = new File(inTargetCharsetFolder + File.separator + file.getName());

try (
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "CP1252"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile), "MacRoman"))
) {

    String line;
    while ((line = reader.readLine()) != null) {
        writer.write(line + "\n");
    }

    return newFile;

} catch (Exception e){
    return file;
}