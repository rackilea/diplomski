ArrayList<String> toppings = new ArrayList<>();
toppings.add("Pepperoni");
toppings.add("Olives");

ArrayList<String> validToppings = new ArrayList<>();
validToppings.add("Pepperoni");
validToppings.add("Salami");
validToppings.add("Olives");
validToppings.add("Cheese");

boolean toppingsValid = validToppings.containsAll(toppings);