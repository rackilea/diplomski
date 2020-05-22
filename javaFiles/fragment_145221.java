ApplicationProperties ap = ComponentAccessor.getApplicationProperties();
String baseUrl = ap.getString(APKeys.JIRA_BASEURL);
String webworkEncoding = ap.getString(APKeys.JIRA_WEBWORK_ENCODING);

VelocityManager vm = ComponentAccessor.getVelocityManager();
VelocityParamFactory vp = ComponentAccessor.getVelocityParamFactory();

Map context = vp.getDefaultVelocityParams();
context.put("test", "test");

String renderedText = vm.getEncodedBody("templates/", "service-now-tab-panel.vm", baseUrl, webworkEncoding, context);

return Collections.singletonList(new GenericMessageAction(renderedText));