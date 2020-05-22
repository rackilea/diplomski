do {
    [...]
    combinaison=appliquerCoup(combinaison,coup);
    System.out.println("=>"+combinaison);
    num++;  
} while(!combinaison.equals("000"));
if(combinaison.equals("000")){ [...] }