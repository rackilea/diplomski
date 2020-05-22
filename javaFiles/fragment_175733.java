private class Remover implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        remove(listOfTextFields.get(listOfTextFields.size()-1));
        listOfTextFields.remove(listOfTextFields.size()-1)
        pack();
        invalidate();
        repaint();
    }
}