import requests
par = {"text": "He is a good boy"}
headers={"Accept" : "application/rdf+xml"}
r = requests.get("http://wit.istc.cnr.it/stlab-tools/fred/",
    data=par, headers=headers)
print r["text"]