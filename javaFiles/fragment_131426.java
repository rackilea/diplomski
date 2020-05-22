boolean error = false;
  for(int x = 0; x < 3; x++)
  {
    for(int xx = 0; xx < 6; xx++)
    {
      if(toppings[x].equalsIgnoreCase(validToppings[xx]))
      {price += 0.75;} else {error = true;};
    }
  }
  if(error){
    System.out.println("Error in Pizza class: Attempt to set invalid pizza topping");
  }