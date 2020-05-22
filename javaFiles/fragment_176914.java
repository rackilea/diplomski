public TradeInDialog(Database _db) throws SQLException
{
    selectedTexture = 1;
    setupSubTexture();
    setupTexture();

    cbTexture.addItemListener(new ItemListener() {

        public void itemStateChanged(ItemEvent e) {

            if(e.getStateChange() == ItemEvent.SELECTED) {
                selectedTexture = cbTexture.getSelectedIndex()+1;
                setupSubTexture();
        }
    });

    cbTexture.setSelectedIndex(0);
}