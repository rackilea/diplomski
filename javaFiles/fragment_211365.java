try {
    for (NamingEnumeration attr = rsa.getAll(); attr.hasMore();) {
        Attribute attribute= (Attribute) attr.next();
        System.out.println("Attribute id: " + attribute.getID());

        for (NamingEnumeration val = attribute.getAll(); val.hasMore();){
            System.out.println("Attribute value: " + val.next());    
        }

    }
} catch (NamingException e) {
    e.printStackTrace();
}