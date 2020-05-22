SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        jTextArea1.append(readtemp(temp));    
    }
});