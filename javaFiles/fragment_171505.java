import urllib2
import urllib # needed for url-encoding
par = {"text": "He is a good boy"}
headers={"Accept" : "application/rdf+xml"}
request = urllib2.Request(
    "http://wit.istc.cnr.it/stlab-tools/fred/?" + urllib.urlencode(par),
    headers=headers)
contents = urllib2.urlopen(request).read()
print contents