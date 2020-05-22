Action nextpictureaction = new AbstractAction("Next Picture") {
    private static final long serialVersionUID = 2421742449531785343L;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!pictures.isEmpty()) {
            System.out.println(pictures.pop().getName());
        }
    }
};