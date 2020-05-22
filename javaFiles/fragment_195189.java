public static Map getSplitMap(File sourceDir) {
        FilenameFilter only = new OnlyExt("RPT");
        log.debug("Getting split Map........");
        Map<String, Integer> map = new HashMap();
        String[] filenames = sourceDir.list(only);
        try {
            for (int k = 0; k < filenames.length; k++) {
                FileInputStream fs = new FileInputStream(sourceDir.getAbsolutePath() + System.getProperty("file.separator") + filenames[k]);
                BufferedReader br = new BufferedReader(new InputStreamReader(fs));

                String strLine;
                int num = 0;
                int splitLine = 0;
                while ((strLine = br.readLine()) != null) {
                    num++;
                    if (strLine.length() == 1) {
                        splitLine = num;

                    }
                    if (splitLine < 60) {
                        map.put(filenames[k], splitLine);
                    }
                }

                fs.close();
                br.close();
            }
        } catch (Exception asd) {
            log.debug(asd.getMessage());
        }
        return map;
    }