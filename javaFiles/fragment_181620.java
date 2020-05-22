private static class MySwingWorker extends SwingWorker<String, Double> {

    private final JProgressBar fProgressBar;
    private final String tpath;
    private final String imagetype;
    private final TextureEditorGUI parent;

    private MySwingWorker(JProgressBar aProgressBar, String tpath, String imagetype, TextureEditorGUI parent) {
        fProgressBar = aProgressBar;
        this.tpath = tpath;
        this.imagetype = imagetype;
        this.parent = parent;
    }

    @Override
    protected String doInBackground() throws Exception {
        File backuppath = new File(tpath + "backup\\");
        File texturepath;
        final File[] files = backuppath.listFiles();
        BufferedImage image;
        final String texpath = tpath;
        for (int i = 0; i < files.length; i++) {
            final int ii = i;
            try {
                System.out.println(files[i].getName());
                System.out.println(files[ii]);
                if (files[ii].getName().contains("." + imagetype)) {
                    texturepath = new File(texpath + files[ii].getName());
                    image = ImageIO.read(files[ii]);
                    ImageIO.write(image, imagetype, texturepath);
                    double proportion = (ii / (double) (files.length - 1)); //count out the indicator file
                    publish(proportion);
                    System.out.println((int) (proportion * 100) + "%");
                }
            } catch (IOException e) {
                System.out.println("Could not open texture files in backup folder");
            }
        }
        return "Finished";
    }

    @Override
    protected void process(List<Double> aDoubles) {
        //update the percentage of the progress bar that is done
        int amount = fProgressBar.getMaximum() - fProgressBar.getMinimum();
        fProgressBar.setValue((int) (fProgressBar.getMinimum() + (amount * aDoubles.get(aDoubles.size() - 1))));
    }

    @Override
    protected void done() {
        try {
            JOptionPane.showMessageDialog(
                    parent.getMainFrame(),
                    "Textures in " + tpath + " have been reverted back",
                    "Notification", JOptionPane.INFORMATION_MESSAGE);
            parent.showMainPane();
        } catch (Exception ignore) {
        }
    }
}