JarFile replace = new JarFile("newgame.jar");
        InputStream is = null;
        JarOutputStream jos = new JarOutputStream(new FileOutputStream(
                Launcher.class.getProtectionDomain().getCodeSource().getLocation().getPath()));
        for (Enumeration<JarEntry> list = replace.entries(); list.hasMoreElements();) {
            JarEntry nextEntry = list.nextElement();
            jos.putNextEntry(nextEntry);
            is = replace.getInputStream(nextEntry);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] byteBuff = new byte[(int) nextEntry.getSize()];
            int bytesRead = 0;
            while ((bytesRead = is.read(byteBuff, 0, byteBuff.length)) != -1)
                out.write(byteBuff, 0, bytesRead);
            jos.write(out.toByteArray());
            out.close();
            is.close();
        }
        replace.close();
        jos.close();
        new File("newgame.jar").delete();