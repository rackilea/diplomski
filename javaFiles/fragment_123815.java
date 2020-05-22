public class Applet_15934232 extends Applet implements ItemListener {
    Panel
            dinnerPanel,
            soupPanel,
            saladPanel;

    Checkbox
            standard, deluxe,
            soup, salad,
            cream, broth, gumbo,
            tossed, caesar,
            croutons, lite;

    //Used to setup all of the boxes and add them to the Applet
    public void init() {
        CheckboxGroup dinnerType = new CheckboxGroup();
        standard = new Checkbox("standard", dinnerType, false);
        standard.addItemListener(this);
        deluxe = new Checkbox("deluxe", dinnerType, true);
        deluxe.addItemListener(this);

        CheckboxGroup soupOrSalad = new CheckboxGroup();
        soup = new Checkbox("Soup", soupOrSalad, false);
        soup.addItemListener(this);
        salad = new Checkbox("Salad", soupOrSalad, false);
        salad.addItemListener(this);

        cream = new Checkbox("cream", false);
        cream.addItemListener(this);
        broth = new Checkbox("broth", false);
        broth.addItemListener(this);
        gumbo = new Checkbox("gumbo", false);
        gumbo.addItemListener(this);

        tossed = new Checkbox("tossed", false);
        tossed.addItemListener(this);
        caesar = new Checkbox("ceasar", false);
        caesar.addItemListener(this);
        croutons = new Checkbox("croutons", false);
        croutons.addItemListener(this);
        lite = new Checkbox("lite", false);
        lite.addItemListener(this);


        //adding the componets to the Applet
        setLayout(new GridLayout(0, 1));

        dinnerPanel = new Panel();
        add(dinnerPanel);
        dinnerPanel.add(standard);
        dinnerPanel.add(deluxe);

        soupPanel = new Panel();
        add(soupPanel);
        soupPanel.add(soup);
        soupPanel.add(cream);
        soupPanel.add(broth);
        soupPanel.add(gumbo);

        saladPanel = new Panel();
        add(saladPanel);
        saladPanel.add(salad);
        saladPanel.add(tossed);
        saladPanel.add(caesar);
        saladPanel.add(croutons);
        saladPanel.add(lite);
    }

    //ItemEvents and calls other functions
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == standard || e.getSource() == deluxe) {
            handleDinnerType((Checkbox) e.getSource());
        } else if (e.getSource() == soup || e.getSource() == salad) {
            handleSoupSaladChoice((Checkbox) e.getSource());
        } else {
            handleButtonSelection((Checkbox) e.getSource());
        }
    }

    private void handleButtonSelection(Checkbox source) {
        cream.setState(source == cream);
        broth.setState(source == broth);
        gumbo.setState(source == gumbo);
        tossed.setState(source == tossed);
        caesar.setState(source == caesar);
        croutons.setState(source == croutons);
        lite.setState(source == lite);
    }

    //helper function for dinner type
    void handleDinnerType(Checkbox selectedType) {
        boolean enabled = false;

        if (selectedType == standard) {
            enabled = false;
        } else if (selectedType == deluxe) {
            enabled = true;
        }

        cream.setEnabled(enabled);
        broth.setEnabled(enabled);
        gumbo.setEnabled(enabled);
        tossed.setEnabled(enabled);
        caesar.setEnabled(enabled);
        croutons.setEnabled(enabled);
        lite.setEnabled(enabled);

    }

    //helper function for salad and soup type
    void handleSoupSaladChoice(Checkbox selectedCourse) {
        boolean soupEnabled = (selectedCourse == soup);
        boolean saladEnabled = (selectedCourse == salad);

        if (soupEnabled) {
            tossed.setState(false);
            caesar.setState(false);
            croutons.setState(false);
            lite.setState(false);
        }
        if (saladEnabled) {
            cream.setState(false);
            broth.setState(false);
            gumbo.setState(false);
        }


        cream.setEnabled(soupEnabled);
        broth.setEnabled(soupEnabled);
        gumbo.setEnabled(soupEnabled);

        tossed.setEnabled(saladEnabled);
        caesar.setEnabled(saladEnabled);
        croutons.setEnabled(saladEnabled);
        lite.setEnabled(saladEnabled);
    }
}