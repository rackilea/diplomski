public class FilePanel /* extends not sure */ {
    private File file;

    ...

    public File getFile() { return file; }
    public void setFile(File f) { file = f; }

    ...
}

/*
 * not sure how your event structure works
 * this is the common way to do it
 *
 * @Override
 * public void actionPerformed(ActionEvent evt) {
 *     if (evt.getSource() == saveAsButton) {
 *         saveAsAction();
 *     } else if (evt.getSource() == saveButton) {
 *         saveAction();
 *     }
 * }
 *
 */

// recommend refactor so "save" can call "save as" without regard to event
private void saveAsAction() {

    int exInput = JOptionPane.NO_OPTION;
    File file = null;

    // use a do-while and "no" to reshow the save dialog if exists

    do {
        int returnVal = fileChooser.showSaveDialog(null);

        if (returnVal != JFileChooser.APPROVE_OPTION) {
            return;
        }

        file = fileChooser.getSelectedFile();

        if (!file.getName().endsWith(".txt")) {
            file = new File(file.getParentFile(), file.getName() + ".txt");
        }

        if (file.exists()) {
            exInput = JOptionPane.showConfirmDialog(
                            null, "This file already exists, overwrite it?");

            if (exInput == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }
    } while (file.exists() && exInput == JOptionPane.NO_OPTION);

    FilePanel selectedComp = (FilePanel)tabbedPane.getSelectedComponent();

    if (selectedComp != null) {
        String text = selectedComp.getTextArea().getText();
        file = writeToFile(file, text);
        selectedComp.setFile(file);

    } else {
        System.out.println("No component selected");
        return;
    }

    tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), file.getName());
    ClosableTab.apply(tabbedPane, tabbedPane.getTabCount() - 1);
}

private void saveAction() {

    FilePanel selectedComp = (FilePanel)tabbedPane.getSelectedComponent();

    if (selectedComp != null) {
        File file = selectedComp.getFile();

        if (file == null) {
            // imply no "save as" performed

            saveAsAction();
            return;
        }

        String text = selectedComp.getTextArea().getText();
        file = writeToFile(file, text);
        selectedComp.setFile(file);

    } else {
        System.out.println("No component selected");
    }
}

// recommend refactor so "save" and "save as" can share write code
private static File writeToFile(File file, String text) {

    try {

        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(text);
        bw.close();

        return file;

    } catch(Exception e) {
        // handle your IO errors better than this
        // files are not willy-nilly!

        System.out.println("err");
        return null;
    }
}