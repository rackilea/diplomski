private static boolean isSimplePagedResultsControlExtensionSupported(
          final LdapContext ctx, final String connectionUrl) throws NamingException {
        Attribute attribute = null;

    try {
      Attributes attributes = ctx.getAttributes("" /* rootDSE */,
          new String[]{"supportedcontrol"});
      attribute = attributes.get("supportedcontrol");
    } catch (NamingException namingException) {
      logger.warning("Error retrieving supportedControls from rootDSE in LDAP authority ["
          + connectionUrl
          + "] - unable to determine if the Simple Paged Results Control Extension (RFC2696) is supported: "
          + namingException.getMessage());
      return false;
    }

    if (attribute == null) {
      logger.warning("Error retrieving supportedControls from rootDSE in LDAP authority ["
          + connectionUrl
          + "] - unable to determine if the Simple Paged Results Control Extension (RFC2696) is supported");
      return false;
    }

    NamingEnumeration<?> namingEnumeration = attribute.getAll();
    while (namingEnumeration.hasMore()) {
      Object object = namingEnumeration.next();
      if (object instanceof String) {
        final String supportedControlOid = (String)object;
        if (supportedControlOid.equals(SIMPLE_PAGED_RESULTS_CONTROL_EXTENSION_OID)) {
          logger.info("LDAP authority [" 
              + connectionUrl 
              + "] reports that it supports the Simple Paged Results Control Extension (RFC2696)"
              + " - a page size of ["
              + DEFAULT_SIMPLE_PAGED_RESULTS_CONTROL_EXTENSION_PAGE_SIZE
              + "] will be used");

          namingEnumeration.close();
          return true;
        }
      }
    }

    logger.info("LDAP authority [" 
        + connectionUrl 
        + "] reports that it does not support the Simple Paged Results Control Extension (RFC2696)");

    namingEnumeration.close();
    return false;
  }