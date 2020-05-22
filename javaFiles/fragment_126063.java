int totalNumberOfPizzas = 10;
List<Pizza> pizzas = new ArrayList<>();
for (int number = 0; number < totalNumberOfPizzas; number++) {
    Pizza pizza = new Pizza();
    // Add Pizza Properties here  like pizza.setSize("LARGE");
    pizzas.add(pizza);
}

System.out.println("All pizzas are ready: " + pizzas);