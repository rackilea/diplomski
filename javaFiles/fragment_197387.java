public class Converter {

    public static void main(String[] args) {
        File rootDir = new File(".");
        renamePackageToPackageInfo(rootDir);
    }

    private static void renamePackageToPackageInfo(File dir) {
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return "package.html".equals(name);
            }
        });
        for (File file : files) {
            convertFile(file);
        }
        // now recursively rename all the child directories.
        File[] dirs = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        for (File subdir : dirs) {
            renamePackageToPackageInfo(subdir);
        }
    }

    private static void convertFile(File html) {
        // determine the FQN package name
        String fqpn = getPackageName(html);

        // check if package-info.java already exists
        File packageInfo = new File(html.getParent(), "package-info.java");
        if (packageInfo.exists()) {
            System.out.println("package-info.java already exists for package: "+fqpn);
            return; 
        }

        // create the i/o streams, and start pumping the data
        try {
            PrintWriter out = new PrintWriter(packageInfo);
            BufferedReader in = new BufferedReader(new FileReader(html));
            out.println("/**");

            // skip over the headers
            while (true) {
                String line = in.readLine();
                if (line.equalsIgnoreCase("<BODY>"))
                    break;
            }
            // now pump the file into the package-info.java file
            while (true) {
                String line = in.readLine();
                if (line.equalsIgnoreCase("</BODY>"))
                    break;
                out.println(" * " + line);
            }

            out.println("*/");
            out.println("package "+fqpn+";");
            out.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // queue the package.html file for deletion
        //html.deleteOnExit();
    }

    private static String getPackageName(File file) {
        StringBuilder path = new StringBuilder(file.getParent());
        // trim the first two characters (./ or .\)
        path.delete(0, 2);
        // then convert all separators into . (HACK: should use directory separator property)
        return path.toString().replaceAll("\\\\", ".");
    }

}