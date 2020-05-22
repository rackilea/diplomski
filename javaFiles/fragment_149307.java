List<String> words = new ArrayList<String>();
words.add("Large pizza");
words.add("mozzarella");
words.add("pepperoni");
words.add("olives");
double total = 8.9;

String order = "";

if(words.size()>1){
    order = words.get(0) + " with ";    
    for(int i = 1; i < words.size(); i++){
        order += " " + words.get(i) + ", ";
    }
    order += "£"+String.format("%.2f", total);
}

System.out.println(order);