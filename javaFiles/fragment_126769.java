public Food eat(Food x) throws Exception
    { 
        if (x instanceof Meat) {
                return x;
            } else {
               throw new Exception("Carnivores only eat meat!");
            }
    }