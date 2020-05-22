boolean tmp = false;
for (int i=0; i < foo.length; i++) {
    if (foo[i] == itemChoice) {
       tmp = true;
    }
}
if (tmp) {
    System.out.print("Valid choice. You picked " + itemChoice);
}  
else {  
    System.out.print("Not a valid choice");  
}