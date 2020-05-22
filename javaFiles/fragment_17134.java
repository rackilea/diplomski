public static HttpSession setSessionAttribute(final HttpSession session, 
final String attributeName,
        final Serializable attributeValue) {
    session.setAttribute(attributeName, attributeValue);
    return session;
  }