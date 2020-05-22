/**
 * Save the given workbook in the specified format.
 * 
 * @param controlSiteAuto the OLE control site to use
 * @param filepath the file to save to
 * @param formatCode XlFileFormat code representing the file format to save as
 * @param replaceExistingWithoutPrompt true to replace an existing file quietly, false to ask the user first
 */
public void saveWorkbook(OleAutomation controlSiteAuto, String filepath, Integer formatCode, boolean replaceExistingWithoutPrompt) {
    Variant[] args = null;
    Variant result = null;
    try {
        // suppress "replace existing?" prompt, if necessary
        if (replaceExistingWithoutPrompt) {
            setPropertyOnObject(controlSiteAuto, "Application", "DisplayAlerts", "False");
        }

        // if the given formatCode is null, for some reason, use a reasonable default
        if (formatCode == null) {
            formatCode = 51;    // xlWorkbookDefault=51
        }

        // save the workbook
        int[] id = controlSiteAuto.getIDsOfNames(new String[] {"SaveAs", "FileName", "FileFormat"});
        args = new Variant[2];
        args[0] = new Variant(filepath);
        args[1] = new Variant(formatCode);
        result = controlSiteAuto.invoke(id[0], args);

        if (result == null || !result.getBoolean()) {
            throw new RuntimeException("Unable to save active workbook");
        }

        // enable alerts again, if necessary
        if (replaceExistingWithoutPrompt) {
            setPropertyOnObject(controlSiteAuto, "Application", "DisplayAlerts", "True");
        }
    } finally {
        cleanup(args);
        cleanup(result);
    }
}

protected void cleanup(Variant[] variants) {
    if (variants != null) {
        for (int i = 0; i < variants.length; i++) {
            if (variants[i] != null) {
                variants[i].dispose();
            }
        }
    }
}