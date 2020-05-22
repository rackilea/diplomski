boolean found = false;
for (Item item : voce) {
    if(item.getNome().equals(chiave)){
        System.out.println(item.toString());
        found = true;
    }
}

if (!found) {
    System.out.println("Nessun match");
}