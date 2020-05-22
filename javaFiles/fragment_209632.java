f = new File("resource\\config\\save.sav");
if(!f.exists()){
    filer.reset();
}
try (BufferedReader br = new BufferedReader(new FileReader(f))) {
    // Load the file...
} catch (IOException ex) {
    Logger.getLogger(filer.class.getName()).log(Level.SEVERE, null, ex);
}