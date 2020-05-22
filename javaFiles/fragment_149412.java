// ...
import com.unboundid.util.Base64;
// ...
Modification passwordReplacementModification = new Modification(
        ModificationType.REPLACE, "userPassword",
        newPassword.getBytes());
ModifyRequest modifyRequest = new ModifyRequest(
        user.getDn(), passwordReplacementModification);
LDAPResult modifyResult = ldapManager.getLdapConnectionAsAdmin().modify(modifyRequest);