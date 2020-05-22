public static void makeNewZipFromInputStreamList(File outputFile,
            ArrayList<InputStream> inputStreamList,
            ArrayList<String> includeList, ArrayList<String> excludeList)
            throws IOException, IllegalArgumentException {
        final int sizeOfLists[] = new int[] { inputStreamList.size(),
                includeList.size(), excludeList.size() };

        if ((sizeOfLists[0] != sizeOfLists[1])
                || (sizeOfLists[0] != sizeOfLists[2])
                || (sizeOfLists[1] != sizeOfLists[2]))
            throw new IllegalArgumentException(
                    "The ArrayLists do not have the same size ("
                            + sizeOfLists[0] + ", " + sizeOfLists[1] + ", "
                            + sizeOfLists[2] + ")");

        final ZipOutputStream zipOutputFile = new ZipOutputStream(
                new FileOutputStream(outputFile));

        final int size = sizeOfLists[0];
        final InputStream inputStreamTempArray[] = inputStreamList
                .toArray(new InputStream[size]);
        final String includeArray[] = includeList.toArray(new String[size]);
        final String excludeArray[] = excludeList.toArray(new String[size]);
        final ZipInputStream inputStreamArray[] = new ZipInputStream[size];

        HashMap<String, Object[]> tmp;

        int i, j;
        String fileName;
        ZipEntry entry;

        for (i = size - 1; i >= 0; i--) {
            inputStreamArray[i] = new ZipInputStream(inputStreamTempArray[i]);

            if (includeArray[i] == null) {
                includeArray[i] = "";
            }

            if (excludeArray[i] == null) {
                excludeArray[i] = "";
            }

            while ((entry = inputStreamArray[i].getNextEntry()) != null) {
                fileName = entry.getName();

                if (fileName.matches(includeArray[i])
                        || !fileName.matches(excludeArray[i])) {
                    try {
                        zipOutputFile.putNextEntry(entry);

                        if (!entry.isDirectory()) {
                            copyStream(inputStreamArray[i], zipOutputFile,
                                    false, false);
                        }
                    } catch (ZipException ex) {
                        if (!ex.getMessage()
                                .matches("duplicate entry: .*\\..*")) {
                            throw new RuntimeException(
                                    "Unexpected " + ex.getClass() + " (\""
                                            + ex.getMessage()
                                            + "\")\n(only duplicate entry execptions are expected!)",
                                    ex);
                        }
                    }
                }
            }

            inputStreamArray[i].close();
        }

        zipOutputFile.close();
    }