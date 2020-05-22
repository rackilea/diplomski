System.out.println("Order Confirmation: ");    
System.out.println(pizza.getPizzaBase().getName() + " crust pizza");
boolean vegetarian = true;
for(PizzaTopping pizzaTopping: pizza.getPizzaToppings()){
    if (pizzaTopping.getName().equals("Ham") || pizzaTopping.getName().equals("ham"))
        vegetarian = false;
    System.out.println("1 x " + pizzaTopping.getName());
}
if (vegetarian)
     System.out.println("Vegetarian")
 else
     System.out.println("Not Vegetarian")