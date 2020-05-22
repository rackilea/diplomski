boolean found = false;
for (int index = 0; index < dataStore.size(); index++) {
        Account datum = (Account)dataStore.get(index);

        if (str.equals(datum.getName())) {
            name = datum.getName();
            textArea.setText("Found Account for " + name);
            found = true;
        }
    }
 if(!found){

     textArea.setText("No Accounts found!");
 }