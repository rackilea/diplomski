jpAnnotation.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)
    {
        JFrame myInternalFrame= (JFrame)SwingUtilities.getWindowAncestor(this);
        myInternalFrame.remove(PDFJPanel.this);
        myInternalFrame.invalidate();
        myInternalFrame.validate();
        myInternalFrame.repaint();
    }
});