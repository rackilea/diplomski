List<String> fileNames = new ArrayList<>();
File folder = new File(Environment.getExternalStorageDirectory(), "InkousticImages");
if (!folder.exists()) folder.mkdir();
for (File file : folder.listFiles()) {
    String filename = file.getName().toLowerCase();
    if (filename.endsWith(".jpg") || filename.endsWith("jpeg")) {
        fileNames.add(filename);
    }
}