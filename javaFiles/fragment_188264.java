public enum DPIResolution {DPI72, DPI150, DPI300, DPI300PLUS}

// Program paths
public static final String PROGRAM_GSWIN64C_PATH = "C:/gs/gs9.16/bin/gswin64c.exe";
public static final String PROGRAM_GSWIN64C_OLD_PATH = "C:/gs/gs9.07/bin/gswin64c.exe";
public static final String PS_TMP_PATH = "D:/tmp.ps";

// Convert PDF Color to PDF Gray
private static int convertPDFColorToPDFGray(String inputPath, String outputPath, DPIResolution dpiResolution){
    String[] cmd = {
        PROGRAM_GSWIN64C_PATH, "-sDEVICE=pdfwrite", "-dPDFSETTINGS=/" + dpiForGS,
        "-sColorConversionStrategy=Gray", "-sColorConversionStrategyForImages=Gray", "-sProcessColorModel=DeviceGray",
        "-dCompatibilityLevel=1.4", "-dNOPAUSE", "-dBATCH",
        "-sOutputFile=" + outputPath, inputPath, "-c", "quit"
    };

    int exitCode = ghostScriptCommand(cmd);
}

// Convert PDF Color to PDF Black and White
private static int convertPDFColorToPDFBlackAndWhite(String inputPath, String outputPath){
    String[] cmd = {
        PROGRAM_GSWIN64C_OLD_PATH, "-sDEVICE=psmono", "-dNOPAUSE", "-dBATCH",
        "-sOutputFile=" + PS_TMP_PATH, inputPath, "-c", "quit"
    };

    String[] cmd2 = {
        PROGRAM_GSWIN64C_PATH, "-sDEVICE=pdfwrite", "-dNOPAUSE", "-dBATCH",
        "-sOutputFile=" + outputPath, PS_TMP_PATH, "-c", "quit"
    };

    int exitCode = ghostScriptCommand(cmd);
    exitCode = ghostScriptCommand(cmd2);

    // We remove the PS tmp file
    File file = new File(PS_TMP_PATH);
    try{
        if(!file.delete()) System.out.println("Erreur de suppression de " + file.getName());
    } catch(Exception e){
        System.err.println("Erreur: " + e.getMessage());
        e.printStackTrace();
    }
};

// Command to Ghost Script (GS)
private static int ghostScriptCommand(String[] cmd){
    try {
        Process process = Runtime.getRuntime().exec(cmd);
        int exitCode = process.waitFor();

        // read the output from the command
        String s;
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String stringstdInput = "- Standard output of the command :\n";
        while ((s = stdInput.readLine()) != null) {
            stringstdInput += s + "\n";
        }
        // read any errors from the attempted command
        boolean hasStdError = false;
        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String stringstdError = "- Standard error of the command :\n";
        while ((s = stdError.readLine()) != null) {
            hasStdError = true;
            stringstdError += s + "\n";
        }
        System.out.print(stringstdInput);
        if(hasStdError) System.err.print(stringstdError);

    } catch (Exception e) {
        System.err.println("Erreur: " + e.getMessage());
        e.printStackTrace();
    }

    return exitCode;
}

private static String dpiResolutionToGS(DPIResolution dpiResolution){
    String dpiForGS;

    switch(dpiResolution){
        case DPI72 :
            dpiForGS = "screen";
            break;
        case DPI150 :
            dpiForGS = "ebook";
            break;
        case DPI300 :
            dpiForGS = "printer";
            break;
        case DPI300PLUS :
            dpiForGS = "prepress";
            break;
        default :
            dpiForGS = "default";
    }

    return dpiForGS;
}