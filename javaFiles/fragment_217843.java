public void setFile(String x)
{
    this.fileLocation = x;
    file = new File(fileLocation);
}
File file;