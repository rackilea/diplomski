public static void count(ArrayList<Double> list) {
  if (list.empty()) {    
     return; // or consider using if/else
  }

  double total = total(list);

  if (total>100) {
    list.remove(0);
    count(list); // recursive call
  } else if (total<100) {
    list.add(0, 100-total);
  }
}