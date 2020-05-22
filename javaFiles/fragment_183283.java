List<Diet> dietList = new ArrayList<Diet>();
Collections.addAll(dietList, new Diet("pizza", null), new Diet(null, "coke");

...

for (Diet diet : dietList) {
    System.out.println("food is " + diet.getFood());
    System.out.println("drink is " + diet.getDrink());
}