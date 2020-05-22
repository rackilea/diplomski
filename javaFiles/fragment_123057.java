if (removeContact != null) { //removeContact should not be null
        for (int i = 0; i < contacts.length; i++) {
            for (int j = 0; j < contacts[i].length; j++) {
                if (removeContact.equals(contacts[i][j])) { //removeContact is not null so check removeContact with contacts[i][j]
                    contacts[i][0] = " ";
                    contacts[i][1] = " ";
                    contacts[i][2] = " ";
                    contacts[i][3] = " ";
                    break; //break the loop once you remove
                }
            }
        }
    }