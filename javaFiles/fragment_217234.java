WURFLHolder wurfl = (WURFLHolder)getServletContext().getAttribute(WURFLHolder.class.getName());

WURFLManager manager = wurfl.getWURFLManager();

Device device = manager.getDeviceForRequest(request);

log.debug("Device: " + device.getId());
log.debug("Capability: " + device.getCapability("preferred_markup"));

MarkUp markUp = device.getMarkUp();

String jspView = null;

if (MarkUp.XHTML_ADVANCED.equals(markUp)) {
  jspView = XHTML_ADV;
} else if (MarkUp.XHTML_SIMPLE.equals(markUp)) {
  jspView = XHTML_SIMPLE;
} else if (MarkUp.CHTML.equals(markUp)) {
  jspView = CHTML;
} else if (MarkUp.WML.equals(markUp)) {
  jspView = WML;
}