FileFilter myFilter = new FileFilter() {
    @Override
    public boolean accept(File file) {
        javax.swing.filechooser.FileFilter ef = 
            new FileNameExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.bmp", "*.jpeg");
        return ef.accept(file) && (file.length() <= (1024L * 1024L));
    }
};
fileChooser.setFileFilter(myFilter);