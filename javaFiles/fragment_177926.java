POST https://www.googleapis.com/dns/v1beta1/projects/*myProject*/managedZones/*myZone.com*/changes

{
  "additions": [
    {
      "name": "computername.myZone.com.",
      "type": "A",
      "ttl": 600,
      "rrdatas": [
        "200.201.202.203"
      ]
    }
  ],
  "deletions": [
  ],
}