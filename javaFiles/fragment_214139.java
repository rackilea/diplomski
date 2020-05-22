import java.io.IOException;
import java.io.InputStream;

public class AutoCadFile {

private String notOpen;
private StringBuilder textBuilder;
private String command;
private int i;
private InputStream myStream;
private String output;
private boolean logical;

public AutoCadFile() {
    notOpen = "INFO: No tasks are running which match the specified criteria";
    textBuilder = new StringBuilder();
    command = "tasklist /fi \"windowtitle eq Autodesk AutoCAD 2017 - [123-4567.dwg]";
    output = textBuilder.toString();
    logical = output.contains(notOpen);

    try {
        myStream = Runtime.getRuntime().exec(command).getInputStream();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void checkForFileOpen() {
    try {
        while ((i = myStream.read()) != -1) {
            textBuilder.append((char) i);
        }
        if (logical) {
            System.out.println("DWG Not Open");
        } else {
            System.out.print(output);
        }
        myStream.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public boolean getFileBoolean() {
    return logical;
}
}