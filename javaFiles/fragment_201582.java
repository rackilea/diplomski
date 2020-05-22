// the informational item
Object noInvoice = "no invoice selected";

// loading the invoice ids
model.removeAllElements();
model.setSelectedItem(noInvoice);
for (int i = 0; i < 20; i++) {
    model.addElement("model: " + count + " item: " + i);
}

// the itemListener ignoring the informational item
if (ItemEvent.SELECTED == e.getStateChange()) {
    if (noInvoice.equals(e.getItem())) return; 
    doLoadDetails(e.getItem());
}