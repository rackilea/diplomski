for(Enumeration enum = ks.aliases(); enum.hasMoreElements(); ) {
    String alias = (String) enum.nextElement();
    System.out.println("@:" + alias);
    if (ks.isKeyEntry(alias)) {
        System.out.println("return PrivateKey");
        PrivateKey pk = (PrivateKey) ks.getKey(alias, password);
        // ...
    }
}