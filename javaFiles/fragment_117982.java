if (SecurityContextAssociation.getSecurityContext()==null)
    SecurityContextAssociation.setSecurityContext(new JBossSecurityContext("background-job"));
SecurityContext current = SecurityContextAssociation.getSecurityContext();
final Object cred = current.getUtil().getCredential();
final Subject s = current.getUtil().getSubject();
final Principal up = current.getUtil().getUserPrincipal();
boolean needToUpdatePrincipal=true;
if (up instanceof TenantPrincipal) {
    if (t.getTenantName().equals(((TenantPrincipal) up).getAdditonalField())) {
        needToUpdatePrincipal=false;
    }
}
if (needToUpdatePrincipal) {
    TenantPrincipal tp=new TenantPrincipal(up.getName());
    tp.setAdditionalField(t.getTenantName());
    current.getUtil().createSubjectInfo(
            , cred, (Subject) s);
}