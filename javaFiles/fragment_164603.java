dig example.cluster-x91qlr44xxxz.us-east-1.rds.amazonaws.com


; <<>> DiG 9.11.3-1ubuntu1.3-Ubuntu <<>> example.cluster-x91qlr44xxxz.us-east-1.rds.amazonaws.com
;; global options: +cmd
;; Got answer:
;; ->>HEADER<<- opcode: QUERY, status: NOERROR, id: 40120
;; flags: qr rd ra; QUERY: 1, ANSWER: 3, AUTHORITY: 0, ADDITIONAL: 1

;; OPT PSEUDOSECTION:
; EDNS: version: 0, flags:; udp: 65494
;; QUESTION SECTION:
;example.cluster-x91qlr44xxxz.us-east-1.rds.amazonaws.com. IN A

;; ANSWER SECTION:
example.cluster-x91qlr44xxxz.us-east-1.rds.amazonaws.com. 5 IN CNAME example.x91qlr44xxxz.us-east-1.rds.amazonaws.com.
example.x91qlr44xxxz.us-east-1.rds.amazonaws.com. 4 IN CNAME ec2-18-209-198-76.compute-1.amazonaws.com.
ec2-18-209-198-76.compute-1.amazonaws.com. 7199 IN A 18.209.198.76

;; Query time: 54 msec
;; SERVER: 127.0.0.53#53(127.0.0.53)
;; WHEN: Fri Dec 14 18:12:08 EST 2018
;; MSG SIZE  rcvd: 178