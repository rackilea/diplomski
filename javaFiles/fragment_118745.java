LdapContext context = new InitialLdapContext(...);
Control[] controls = { new BasicControl(
    "1.3.6.1.4.1.4203.666.5.12", // OID
    true, // criticality
    null // control value
) };
context.setRequestControls(controls);