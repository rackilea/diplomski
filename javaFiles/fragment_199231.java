Ingredient lemon = new Ingredient("lemon");
    Ingredient powder = new Ingredient("powder");

    HashMap<Ingredient,HashMap<uom,Integer>> portion = new HashMap<Ingredient,HashMap<uom,Integer>>();

    portion.put(lemon,new HashMap<uom, Integer>(){{put(uom.unit,1);}});
    portion.put(powder,new HashMap<uom, Integer>(){{put(uom.cup,2);}});

    Recipe lemon_cake = new Recipe("lemon cake","bla bla",portion,"Mr Martin");