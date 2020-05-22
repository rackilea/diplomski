public class MyActionForm extends org.apache.struts.action.ActionForm {

private static org.apache.struts.upload.FormFile file;
private static String anyname;

public static FormFile getFile() {
    return file;
}

public void setFile(FormFile file) {
    this.file = file;
}

public static String getAnyname() {
    return anyname;
}

public void setAnyname(String anyname) {
    this.anyname = anyname;
}