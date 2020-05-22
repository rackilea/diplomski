class UI {

    // GUI members:
    private JButton txMaxUserQueryButton;
    /* Omitted GUI instance vars */

    // User input members:
    private double txMax;
    /* Omitted user input vars */

    // Constructor:
    public UI() {
        /* Omitted code, construct GUI members */
        this.txMaxUserQueryButton = new JButton("Enter txMax val!");
        /* More omitted code, construct GUI members */
        this.addEventHandlers();
        this.renderLayout();
    }

    private void addEventHandlers() {
        /* Omitted code, add event handlers */
        this.txMaxUserQueryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String txMaxStrVal = String.valueOf(JOptionPane.showInputDialog("Entrer le seuil MAXIMAL de TxPower a dessus de lequel \n on recommande une intervention immédiate "));
                JOptionPane.showMessageDialog(null,"la nouvelle TxPower est : "+"-"+txMaxStrVal+"dBm");
                double txmax_reel  = Double.parseDouble(txMaxStrVal);
                setTxMax(txmax_reel);
            }
        });
        /* More omitted code, add event handlers */
    }

    public void renderLayout() {
        /* Omitted code, renders layout */
    }

    // Getters:
    public double getTxMax() {
        return this.txMax;
    }

    /* Omitted Getters for other vars */

    // Setters:
    public void setTxMax(double txMax) {
        this.txMax = txMax;
    }

    /* Omitted Setters for other vars */
}