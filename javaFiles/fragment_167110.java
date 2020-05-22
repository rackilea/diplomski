for(int i = 0; i < criminals.length; i++){
    if(searchKey.compareTo(criminals[i][1]) == 0){
        if(!found) {
            found = true;
            System.out.println("Criminals found.");
        }
        System.out.println(criminals[i][0] + " - " + criminals[i][1] + " - " + criminals[i][2]);
    }
}

if(found == false){
    System.out.println("Error! Crime not found.");
}