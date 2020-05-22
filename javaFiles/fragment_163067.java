if (gender.equals("male")) { //equals
    genderValue = 0.7;
}
else if (gender.equalsIgnoreCase("female")) { //Here the equalsIgnorecase one
    genderValue = 0.6;
}
else if (gender == "") {
    settingsAlert();
} else {
    settingsAlert();  //Probably it always comes here.
}