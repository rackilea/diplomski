String[] split = jext.split("\\s+");
if (split.length == 2) { // How you want it to work with 3 or more elements?
    firstname = split[0];
    lastname = split[1];

    texts.setText("FirstName: " + firstname + "\nLastName: " + jext);
}