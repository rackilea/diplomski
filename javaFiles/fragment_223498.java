public double calcCost(){
  switch (pizza_size.toLowerCase()) {
    case "small":
        return 10 + ((pizza_cheese + pizza_pep + pizza_ham)*2);
    case "medium":
        return 12 + ((pizza_cheese + pizza_pep + pizza_ham)*2);
    case "large":
        return 14 + ((pizza_cheese + pizza_pep + pizza_ham)*2);
    default:
        System.out.println("Inside of calcCost if");
        System.out.println("Invalid pizza size");
        return 0;
    }
}