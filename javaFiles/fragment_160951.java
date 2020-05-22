public static void main(String[] a) {
    JFrame fram = new JFrame();
    FoldersAndFiles b = new FoldersAndFiles();

    JScrollPane pane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    pane.getViewport().add(b);
    fram.getContentPane().add(pane);

    b.addToTotalFolderAndFiles(new FolderAndFilePaths());
    fram.pack();
    fram.setVisible(true);
    fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}