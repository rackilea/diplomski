public File createPng(String name) throws Exception {
    String nameFile = "file_"+name.trim();
    String sufix = "png";        

    result = File.createTempFile(nameFile, sufix);

    ImageIO.write(bfImagem, "png", result);

    return result;
}