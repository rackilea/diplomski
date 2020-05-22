Vector<String> attributeValues = new Vector();
    attributeValues.add("CN=nw-PPARead,OU=LDAP,OU=NSC Managed,OU=Global,OU=Groups,DC=NWIE,DC=NET");
    if (attributeValues != null) {
        System.out.println("attributeValues not null = " + attributeValues); // 4
        if (attributeValues.contains("CN=nw-PPARead,OU=LDAP,OU=NSC Managed,OU=Global,OU=Groups,DC=NWIE,DC=NET")
                || attributeValues
                        .contains("CN=nw-PPARead,OU=LDAP,OU=NSC Managed,OU=Global,OU=Groups,DC=NWIEPILOT,DC=NET")
                || attributeValues
                        .contains("CN=nw-PPAWrite,OU=LDAP,OU=NSC Managed,OU=Global,OU=Groups,DC=NWIE,DC=NET")
                || attributeValues.contains(
                        "CN=nw-PPAWrite,OU=LDAP,OU=NSC Managed,OU=Global,OU=Groups,DC=NWIEPILOT,DC=NET")) {
            // Not getting to below statement
            System.out.println("AttributeValues out of first if" + attributeValues); // 5
        }