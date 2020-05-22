import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@Named("GlassfishLogFileController")
@ViewScoped
public class GlassfishLogFile implements Serializable {

String data;

String id;

private int offset = 0;
private int pageSize = 30;
// Path for Glassfish directory with log files
String path = "/opt/glassfish3/glassfish/domains/domain1/logs/" + this.id;

// Constructor
public GlassfishLogFile() {
// Get the ID value
try {
    this.id = FacesContext.getCurrentInstance().getExternalContext()
            .getRequestParameterMap().get("id");
    // We load the first page initially!
    this.actionNextPage();
} catch (Exception e) {
    this.id = null;
}
}

public String actionClearOffset() {
this.offset = 0;
this.actionNextPage();
return "SUCCESS";
}

public String actionNextPage() {
StringBuilder page = new StringBuilder();

for (int i = 0; i < this.pageSize; i++) {
    String line = this.readLine(this.offset);
    if (line == null) {
    break;
    }
    System.out.println(this.offset);
    this.offset += line.length() + 2;
    page.append(line).append(System.getProperty("line.separator"));
}
this.data = page.toString();
return "SUCCESS";
}

public String getData() {
return this.data;
}

public int getPageSize() {
return this.pageSize;
}

public String readLine(long offset) {
String strLine = null;
DataInputStream in = null;
try {
    // Open the file that is the first
    // command line parameter
    FileInputStream fstream = new FileInputStream(new File(this.path));
    // Get the object of DataInputStream
    in = new DataInputStream(fstream);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));

    br.skip(offset);

    strLine = br.readLine();
    // Close the input stream
} catch (Exception e) {// Catch exception if any
    System.err.println("Error: " + e.getMessage());
} finally {
    try {
    in.close();
    } catch (IOException e) {
    e.printStackTrace();
    }
}
return strLine;
}

public void setData(String data) {

}
}