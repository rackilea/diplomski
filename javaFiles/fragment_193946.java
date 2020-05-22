List<String> list = new ArrayList<>();
File file = new File(dir.getAbsolutePath(), "SavedJavaArithmetic.txt");

try (FileWriter fileW = new FileWriter(file);
            BufferedWriter buffW = new BufferedWriter(fileW)) {
    for (int i = 0; i < list.size(); i++) {
        buffW.write(list.get(i));
        buffW.newLine();
    }
}