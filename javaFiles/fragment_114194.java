class plusListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        result2 = display.getText();
        resetOprations();
        plusknopkeus = true;
        result22 = Integer.parseInt(result2);
        display.setText("");

    }
}

class maalListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        result2 = display.getText();
        resetOprations();
        maalknopkeus = true;
        result22 = Integer.parseInt(result2);
        display.setText("");
    }
}

class deelListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        result2 = display.getText();
        resetOprations();
        deelknopkeus = true;
        result22 = Integer.parseInt(result2);
        display.setText("");
    }
}

class minListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        result2 = display.getText();
        resetOprations();
        minknopkeus = true;
        result22 = Integer.parseInt(result2);
        display.setText("");
    }
}

public void resetOprations() {
    deelknopkeus = false;
    plusknopkeus = false;
    minknopkeus = false;
    maalknopkeus = false;
}

class isListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        // result2 = display.getText();
        result11 = Integer.parseInt(result1);

        display.setText(result22 + "");
        if (plusknopkeus) {
            result22 = result22 + result11;
        } else if (minknopkeus) {
            result22 = result22 - result11;
        } else if (maalknopkeus) {
            result22 = result22 * result11;
        }else if (deelknopkeus) {
            result22 = result22 / result11;
        }
        display.setText(result22 + "");

    }
}