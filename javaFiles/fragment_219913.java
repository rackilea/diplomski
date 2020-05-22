boolean termFound = false;
for (int i = 0; i <= names.length - 1; i++) {
        if (searchTerm.equals(names[i])) {
            System.out.println(searchTerm + " found!!");
            termFound = true;
            break;//if term is found, you can break out of the loop early
        }

}  
if(!termFound){ //if searchTerm was not found
        System.out.println(sertTerm + " not found!!");
}