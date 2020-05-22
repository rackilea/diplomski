CodeSource src = JARCLASSNAME.class.getProtectionDomain().getCodeSource();
            if (src != null) {
              URL jar = src.getLocation();
              ZipInputStream zip = new ZipInputStream(jar.openStream());
              while(true) {
                ZipEntry e = zip.getNextEntry();
                if (e == null)
                  break;
                String name = e.getName();
                // Check the folder name if folder name match then only read the file
                if (name.startsWith("com/foo/bar/images")) {

                    InputStream inputStream =JARCLASSNAME.class.getClassLoader().getResourceAsStream(name);


              }
            } 
            }