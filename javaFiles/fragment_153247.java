% dig ds047037.mongolab.com

; <<>> DiG 9.8.3-P1 <<>> ds047037.mongolab.com
;; global options: +cmd
;; Got answer:
;; ->>HEADER<<- opcode: QUERY, status: NOERROR, id: 20375
;; flags: qr rd ra; QUERY: 1, ANSWER: 4, AUTHORITY: 0, ADDITIONAL: 0

;; QUESTION SECTION:
;ds047037.mongolab.com.     IN  A

;; ANSWER SECTION:
ds047037.mongolab.com.  120 IN  CNAME   ds047037-a.mongolab.com.
ds047037-a.mongolab.com. 120    IN  CNAME   h000432.mongolab.com.
h000432.mongolab.com.   120 IN  CNAME   ec2-46-51-159-130.eu-west-1.compute.amazonaws.com.
ec2-46-51-159-130.eu-west-1.compute.amazonaws.com. 300 IN A 46.51.159.130

;; Query time: 23 msec
;; SERVER: 192.168.1.1#53(192.168.1.1)
;; WHEN: Sat Jan 12 13:22:24 2013
;; MSG SIZE  rcvd: 162