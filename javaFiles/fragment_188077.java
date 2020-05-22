UNEdifactInterchange41 edi = new UNEdifactInterchange41();
UNB41 header = new UNB41();
header.setSender(null);
Party sender = new Party();
sender.setInternalId("TEST");
header.setSender(sender);
edi.setInterchangeHeader(header);

Smooks smooks = new Smooks("edi-output-smooks-config.xml");

ExecutionContext executionContext = smooks.createExecutionContext();
Exports exports = Exports.getExports(smooks.getApplicationContext());
Result[] results = exports.createResults();

smooks.filterSource(executionContext, new JavaSource(edi), results);

List<Object> objects = Exports.extractResults(results, exports);
JavaResult.ResultMap map = (JavaResult.ResultMap) objects.get(0);

D98AInterchangeFactory factory = D98AInterchangeFactory.getInstance();
UNEdifactInterchange41 u = (UNEdifactInterchange41) map.get("unEdifactInterchange");

// Should output EDI message as String, but StringWriter is empty
StringWriter ediOutStream1 = new StringWriter();
factory.toUNEdifact(u, ediOutStream1);