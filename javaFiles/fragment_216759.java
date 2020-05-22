for (int i = 0; i < phoneContacts.size(); i++) {                  
    UserAgenda pc = phoneContacts.get(i);
    for (UserAgenda sc : serverContacts) {
        if (pc.getEmails() != null) {
            ArrayList<String> emailsPc = new ArrayList<String>(pc.getEmails());
            for (String epc: emailsPc) {
                ArrayList<String> emailList = new ArrayList<String>(sc.getEmails());                    
                String emailServer = emailList.get(0);
                if (epc.equals(emailServer)) {
                    pc = sc;
                    // Replace the value in the collection too...
                    phoneContacts.set(i, sc);
                    // Do you want to break here?
                }
            }
        }
    }
}