public class FileReplace {
    List<String> lines = new ArrayList<String>();
    String line = null;

    public void  doIt() {
        try {
            File f1 = new File("d:/new folder/t1.htm");
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (line.contains("java"))
                    line = line.replace("java", " ");
                lines.add(line);
            }
            fr.close();
            br.close();

            FileWriter fw = new FileWriter(f1);
            BufferedWriter out = new BufferedWriter(fw);
            for(String s : lines)
                 out.write(s);
            out.flush();
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        FileReplace fr = new FileReplace();
        fr.doIt();
    }
}