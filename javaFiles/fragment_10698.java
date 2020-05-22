for (int index = 0; index < dataStore.size(); index++) {
        Account datum = (Account)dataStore.get(index);

        if (str.equals(datum.getName())) {
            name = datum.getName();
            textArea.setText("Found Account for " + name);
        }
        else
            textArea.setText("No Accounts found!");

    }