public final class LoadProjectAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                // output window
                InputOutput io = IOProvider.getDefault().getIO("File search", true);
                io.select();

                // start in user home directory
                File initialDirectory = new File(
                    System.getProperty("user.home")
                    + File.separator + "lib");

                FileChooserBuilder fileChooserBuilder = new FileChooserBuilder(
                    "LoadProjectAction");
                fileChooserBuilder.setTitle("Load project");
                fileChooserBuilder.setDefaultWorkingDirectory(initialDirectory);
                fileChooserBuilder.setApproveText("Load");
                fileChooserBuilder.setDirectoriesOnly(true);

                JFileChooser jfc = fileChooserBuilder.createFileChooser();
                int value = jfc.showOpenDialog(WindowManager.getDefault().getMainWindow());

                if (value != JFileChooser.APPROVE_OPTION) {
                    return; // nothing to do
                }

                // process selection
            }
        });

    }
}