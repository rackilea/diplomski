public void actionPerformed(ActionEvent e) {
    String Action = e.getActionCommand();

    if (Action.equals("On")) {
        lightbulb.setState(true);
        twentyWatt.setEnabled(true);
        fortyWatt.setEnabled(true);
        sixtyWatt.setEnabled(true);
        lightTimer.setEnabled(true);
        statusText.setText("\t"+lightbulb.toString());
        this.repaint();
    } else if (Action.equals("Off")) {
        lightbulb.setState(false);
        twentyWatt.setEnabled(false);
        fortyWatt.setEnabled(false);
        sixtyWatt.setEnabled(false);
        lightTimer.setEnabled(false);
        statusText.setText("\t"+lightbulb.toString());
        this.repaint();
    } else if (Action.equals("20W")) {
        lightbulb.setWattage(20);
        statusText.setText("\t"+lightbulb.toString());
        this.repaint();
    } else if (Action.equals("40W")) {
        lightbulb.setWattage(40);
        statusText.setText("\t"+lightbulb.toString());
        this.repaint();
    } else if (Action.equals("60W")) {
        lightbulb.setWattage(60);
        statusText.setText("\t"+lightbulb.toString());
        this.repaint();
    } else if (Action.equals("comboBoxChanged")) {
        String item = (String) lightTimer.getSelectedItem();
        if (item.equals("Morning")) {
            lightbulb.setTime("Morning");
            statusText.setText("\t"+lightbulb.toString());
            this.repaint();
        } else if (item.equals("Evening")) {
            lightbulb.setTime("Evening");
            statusText.setText("\t"+lightbulb.toString());
            this.repaint();
        } else if (item.equals("All day")) {
            lightbulb.setTime("All day");
            statusText.setText("\t"+lightbulb.toString());
            this.repaint();
        }
    }
}