AccessControlContext acc = AccessController.getContext();
Subject subject = Subject.getSubject(acc);
Set principals = subject.getPrincipals(JMXPrincipal.class);
if(principals != null && !principals.isEmpty()) {
    Principal principal = (Principal)principals.iterator().next();
    //your checks
}