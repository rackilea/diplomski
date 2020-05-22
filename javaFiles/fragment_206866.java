public static boolean zipFile(final File fileToZip, final File zippedFile) {
            boolean successStatus = false;
            BufferedReader in = null;
            ZipOutputStream out = null;

        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(
                    fileToZip), "UTF-8"));
            out = new ZipOutputStream(new FileOutputStream(zippedFile));
            out.putNextEntry(new ZipEntry(fileToZip.getName()));
            String line;
            final byte[] newLine = System.getProperty("line.separator")
                    .getBytes("UTF-8");

            while ((line = in.readLine()) != null) {
                final byte[] buffer = line.getBytes("UTF-8");
                out.write(buffer, 0, buffer.length);
                out.write(newLine, 0, newLine.length);
            }

            out.closeEntry();
            out.finish();
            successStatus = true;
        } catch (final IOException ex) {
            successStatus = false;
        } finally {
            try {
                if (in != null) {
                    in.close();
                    in = null;
                }
            } catch (final IOException ex) {

            }
            try {
                if (out != null) {
                    out.close();
                    out = null;
                }
            } catch (final IOException ex) {

            }
        }
        return successStatus;
    }