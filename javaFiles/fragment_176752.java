@PrePassivate
public void prePassivate() {
    noStateBean = null;
}

@PostActivate
public void postActivate() {
    // The lookup string is correct assuming the ejb module is deployed within an ear. If your setup is different the JNDI lookup name may be slightly different.
    noStateBean = InitialContext.doLookup("java:module/NoStateBean!NoState");
}