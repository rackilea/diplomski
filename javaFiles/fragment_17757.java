String[] full = { "a1a", "b2b", "c3c" };
String doT = "b2";

for(int i = 0; i < full.length; i++) {
    if(full[i].contains(doT)) {
        System.out.println("Found item at index " + i);
    }
}