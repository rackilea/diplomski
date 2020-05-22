public static void main(String[] args) {
    String[] coinNames ={"Quarters","Dimes","Nickels","Pennies"};
    JList coinList = new JList (coinNames);
    String myCoin = (String) coinList.getModel().getElementAt(0);
    System.out.println(myCoin);

    /* LIST AL YOUR COINNAMES */

    System.out.println("\nCoinList\n");

    for(int i =0; i < coinList.getModel().getSize(); i++){
        System.out.println((String) coinList.getModel().getElementAt(i));
    }

    coinNames[0] = "My new Value"; // Edit your CoinNames at index 0

    /* LIST AL YOUR NEW COINNAMES */

    System.out.println("\nNew coinList edited\n");

    for(int i =0; i < coinList.getModel().getSize(); i++){
        System.out.println((String) coinList.getModel().getElementAt(i));
    }
}