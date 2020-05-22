File original = new File("G:/backup/default0/default.js");
File tmp = new File("G:/backup/default0/tmpdefault.js");
boolean replace = false;
try (FileReader fr = new FileReader(original);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(tmp);
                BufferedWriter bw = new BufferedWriter(fw)) {
    String line = null;
    while ((line = br.readLine()) != null) {
        if (line.contains("1.1.0")) {
            System.out.println("searched");
            line = line.replace("1.1.0", "1.1.1");
            bw.write(line);
            bw.newLine();
            System.out.println("String replaced");
        }
    }
    replace = true;
} catch (Exception e) {
    e.printStackTrace();
}
// Doing this here because I want the files to be closed!
if (replace) {
    if (original.delete()) {
        if (tmp.renameTo(original)) {
            System.out.println("File was updated successfully");
        } else {
            System.err.println("Failed to rename " + tmp + " to " + original);
        }
    } else {
        System.err.println("Failed to delete " + original);
    }
}