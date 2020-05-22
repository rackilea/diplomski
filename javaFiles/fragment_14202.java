JMenuBar buildMenu() {
    final JMenuBar mb = new JMenuBar();
    JMenu menu = mb.add(new JMenu("Meals"));
    for(int ix = 0; ix < meals.length; ix++) {
        final int currMealCosts = mealCosts[ix];
        menu.add(meals[ix]).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                mealCost = currMealCosts;
                updateTotalCosts();
            }
        });
    }
    menu = mb.add(new JMenu("Dorms"));
    for(int ix = 0; ix < dorms.length; ix++) {
        final int currDormCosts = dormCosts[ix];
        menu.add(dorms[ix]).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                dormCost = currDormCosts;
                updateTotalCosts();
            }
        });
    }
    return mb;
}