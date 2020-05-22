static String[] dorms  = { "Allen Hall", "Pike Hall", "Farthing Hall" };
static int[] dormCosts = {           10,          20,              40 };
static String[] meals  = { "7 / weak", "14 / week", "unlimited" };
static int[] mealCosts = {          5,           8,          15 };
JTextField totalField = new JTextField();
int dormCost = dormCosts[0];
int mealCost = mealCosts[0];

void updateTotalCosts() {
    int totalCost = dormCost + mealCost; // really plus not multiply?
    totalField.setText("$" + totalCost);
}

JMenuBar buildMenu() {
    final JMenuBar mb = new JMenuBar();
    JMenu menu = mb.add(new JMenu("Meals"));
    for(int ix = 0; ix < meals.length; ix++) {
        int currMealCosts = mealCosts[ix];
        menu.add(meals[ix]).addActionListener(ev -> {
            mealCost = currMealCosts;
            updateTotalCosts();
        });
    }
    menu = mb.add(new JMenu("Dorms"));
    for(int ix = 0; ix < dorms.length; ix++) {
        int currDormCosts = dormCosts[ix];
        menu.add(dorms[ix]).addActionListener(ev -> {
            dormCost = currDormCosts;
            updateTotalCosts();
        });
    }
    return mb;
}