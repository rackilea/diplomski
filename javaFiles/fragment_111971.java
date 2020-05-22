SandwichBuilder sb = new SandwichBuilder();
sb.addFirstBread(new BreadSlice());
sb.addCheese(new Cheese());
...
sb.addLastBread(new BreadSlice());
Sandwich s = sb.getSandwich();