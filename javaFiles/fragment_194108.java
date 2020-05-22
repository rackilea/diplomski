public void myCopy() throws IOException {
InputStream source = null;
    try {
    source = new FileInputStream("yourInputFile");
        // If anything bad happens, I have a finally clause that protects this now   
        OutputStream destination = null;
    try {
        destination = new FileOutputStream("yourOurputFile"); // If fails, my Input will be closed thanks to its own finally
            performCopy(source, destination); // If this fail, my destination will also be closed thanks to its own finally
        } finally {
            if(destination!=null) { try { destination.close(); } catch (Exception e) {/* log*/ }}
        }
    } finally {
        if(source!=null) { try { source.close(); } catch (Exception e) {/* log*/ }}
    }
}