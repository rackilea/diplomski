String contextPath = getServletContext().getContextPath();

// First reconfigure log4j
String contextName = contextPath.substring(1);
if (!configureLog4J(contextName)) {
  return;
}