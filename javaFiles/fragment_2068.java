public class Tst {

public static void main(String[] args) {
    File orgDirectory = new File("attachements");// replace this filename 
                                                 // with the path to the folder 
                                                 // that contains the original images

    String fileContent = "";
    try (BufferedReader br = new BufferedReader(new FileReader(new File(orgDirectory, "attachements.txt")))) {
        for (String line; (line = br.readLine()) != null;) {
            fileContent += line;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    String[] newLocations = fileContent.split(" ");
    File[] orgFiles = orgDirectory.listFiles(new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.getPath().endsWith(".gif");
        }
    });
    File destinationFolder = new File("processed");
    int max = Math.min(orgFiles.length, newLocations.length);
    for (int i = 0; i < max; i++) {
        String newLocation = newLocations[i];
        int lastIndex = newLocation.lastIndexOf("/");
        if (lastIndex == -1) {
            continue;
        }
        String newDirName = newLocation.substring(0, lastIndex);
        String newName = newLocation.substring(lastIndex);
        File newDir = new File(destinationFolder, newDirName);
        if (!newDir.exists()) {
            newDir.mkdir();
        }
        try {
            Files.move(orgFiles[i].toPath(), new File(newDir, newName).toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
}