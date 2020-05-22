List<Dice> myInventory = new ArrayList<Dice>();
for (Dice die : bigList) {
    if ("YES".equalsIgnoreCase(die.getHaveIt())) {
        myInventory.add(die);
    }
}
return myInventory;