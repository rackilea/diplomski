public String printHobbies() {
    for (int j = 0; j < myHobbies.length; j++) {
        if(myHobbies[j] != null) {
            hobbyText += myHobbies[j].toString();
        }
    }  
    return hobbyText;
}