import javax.naming.ldap.LdapName;
import javax.naming.ldap.Rdn;

String dn = subjectDN.getName();
LdapName ldapDN = new LdapName(dn);
for(Rdn rdn: ldapDN.getRdns()) {
    System.out.println(rdn.getType() + " -> " + rdn.getValue());
}