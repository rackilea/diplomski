public void moveFile(String source, String targetDir)
{
    Path dirpath = Paths.get(targetDir);

    if (Files.exists(dirpath)) {

        Path target = dirpath.resolve(targetDir);

        try {
            Files.move(Paths.get(source), dirpath.resolve(target), REPLACE_EXISTING);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    else {
        new File(targetDir).mkdir();
        moveFile(source, targetDir);
    }
}