public void generateReport()
{
Process p;
try {
    p = Runtime.getRuntime().exec("C:\\pdflatex.exe -synctex=1 -interaction=nonstopmode ./config/log/document.tex");
    p.waitFor();
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (InterruptedException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}