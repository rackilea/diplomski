[...]
proxy.newHar("Test");

HttpGet get = new HttpGet(getLocalServerHostnameAndPort() + "/a.txt?foo=bar&a=1%262");
client.execute(get);

Har har = proxy.getHar();
HarLog log = har.getLog();

List<HarEntry> entries = log.getEntries();

HarEntry entry = entries.get(0);
HarRequest req = entry.getRequest();
[...]