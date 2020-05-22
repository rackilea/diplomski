final JFileChooser opener = new JFileChooser();
JList<Class<?>> list = findFileList(opener);
LOOP_TEMP1: for (MouseListener l : list.getMouseListeners()){
    if (l.getClass().getName().indexOf("FilePane") >= 0){
        list.removeMouseListener(l);
        list.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1){
                    File file = opener.getSelectedFile();
                    if (file != null){
                        BasicFileChooserUI ui = (BasicFileChooserUI) opener.getUI();
                        ui.setFileName(file.getName());
                    }
                }
                else if (e.getClickCount() == 2){
                    File file = opener.getSelectedFile();
                    if (file != null){
                        if (file.isDirectory()){
                            opener.setCurrentDirectory(file);
                        }
                        else if (file.isFile()){
                            opener.setSelectedFile(file);
                        }
                        BasicFileChooserUI ui = (BasicFileChooserUI) opener.getUI();
                        ui.setFileName(file.getName()); 
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });
        break LOOP_TEMP1;
    }
}