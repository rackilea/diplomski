static double firstValue(String s) {
    return Double.parseDouble(s.split("\\s", 2)[0]);
}

double max = firstValue(db_list.getItem(0));
int loc = 0;
for (int i = 1; i < db_list.getItemCount(); i++) {
    double next = firstValue(db_list.getItem(i));
    if (next > max) {
        loc = i;
        max = next;
    }
}

System.out.println("The Maximum is: " + max + " at " + loc);