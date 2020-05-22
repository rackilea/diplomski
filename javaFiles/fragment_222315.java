static ArrayList<File> images = new ArrayList<>();

public static void main(String[] args) throws IOException{
    Files.walk(Paths.get("path")).forEach(filePath -> {
        if (Files.isRegularFile(filePath)) {
            images.add(new File(filePath.toString()));
        }
    });
    for (int i = 0; i < images.size(); i ++){
        images.get(i).renameTo(new File("path" + "\\" + "text" + i + ".jpg"));
    }


}