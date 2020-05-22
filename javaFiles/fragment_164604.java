; <<>> DiG 9.11.3-1ubuntu1.3-Ubuntu <<>> example.cluster-x91qlr44xxxz.us-east-1.rds.amazonaws.com
;; global options: +cmd
;; Got answer:
;; ->>HEADER<<- opcode: QUERY, status: NOERROR, id: 27191
;; flags: qr rd ra; QUERY: 1, ANSWER: 3, AUTHORITY: 0, ADDITIONAL: 1

;; OPT PSEUDOSECTION:
; EDNS: version: 0, flags:; udp: 65494
;; QUESTION SECTION:
;example.cluster-x91qlr44xxxz.us-east-1.rds.amazonaws.com. IN A

;; ANSWER SECTION:
example.cluster-x91qlr44xxxz.us-east-1.rds.amazonaws.com. 5 IN CNAME example-us-east-1a.x91qlr44xxxz.us-east-1.rds.amazonaws.com.
example-us-east-1a.x91qlr44xxxz.us-east-1.rds.amazonaws.com. 4 IN CNAME ec2-3-81-195-23.compute-1.amazonaws.com.
ec2-3-81-195-23.compute-1.amazonaws.com. 7199 IN A 3.81.195.23

;; Query time: 158 msec
;; SERVER: 127.0.0.53#53(127.0.0.53)
;; WHEN: Fri Dec 14 18:15:33 EST 2018
;; MSG SIZE  rcvd: 187