javap -classpath . com.prosc.io.ZipCreator
Compiled from "ZipCreator.java"
public class com.prosc.io.ZipCreator extends java.lang.Object{
    public com.prosc.io.ZipCreator();
    public java.lang.Integer getLevel();
    public void setLevel(java.lang.Integer);
    public void createZip(java.io.File, java.io.File)       throws java.io.IOException;
    public void createZip(java.io.File, java.util.zip.ZipOutputStream)       throws java.io.IOException;
    public void setMaximumZipSize(long);
    static {};
}