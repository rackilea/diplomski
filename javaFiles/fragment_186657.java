boolean found = false;

for (int i = 0; i < tab.length; i++) {
    if(message.startsWith(tab[i])){
        found = true;
        break;
    }
}

if (!found) {
    System.out.println("Ask using why or Why");
}