public static void splitFile(File sourceDir) {
        Map<String, Integer> map = getSplitMap(sourceDir);
        try {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                FileInputStream fs = new FileInputStream(sourceDir.getAbsolutePath() + System.getProperty("file.separator") + entry.getKey());
                BufferedReader br = new BufferedReader(new InputStreamReader(fs));
                FileOutputStream fos = new FileOutputStream(sourceDir.getAbsolutePath() + System.getProperty("file.separator") + entry.getKey() + ".LST");
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                for (int i = 1; i < entry.getValue(); i++) {
                    br.readLine();
                }
                String strLine;
                while ((strLine = br.readLine()) != null) {
                    bw.write(strLine);
                    bw.newLine();
                    bw.flush();
                }
                fs.close();
                br.close();
                fos.close();
                bw.close();
                File files = new File(sourceDir.getAbsolutePath() + System.getProperty("file.separator") + entry.getKey());
                files.delete();
            }
        } catch (Exception asd) {
            log.debug(asd.getMessage());
        }
    }