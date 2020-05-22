//...
HashMap<String, Double> list = new HashMap<String, Double>();
int quantity = 1;
//...
switch (number) {
    case 1:
        //...
        if (list.containsKey(item)) {
            quantity += 1;
            list.put(item, list.get(item) + list.get(item));
        }
        //...
        break;
    //...
    case 3:
        for (String i : list.keySet()) {
            System.out.println(quantity + " " +  i + " " + " " + list.get(i));
        }
        break;
}
//...