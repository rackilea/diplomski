ksql> PRINT 'addresses' FROM BEGINNING ;
Format:JSON
{"ROWTIME":1558519823351,"ROWKEY":"null","id":1,"customer_id":1004,"street":"8 Moulton Center","city":"Bronx","state":"New York","zip":"10474","type":"BILLING"}
{"ROWTIME":1558519823351,"ROWKEY":"null","id":2,"customer_id":1001,"street":"5 Hollow Ridge Alley","city":"Washington","state":"District of Columbia","zip":"20016","type":"LIVING"}
{"ROWTIME":1558519823351,"ROWKEY":"null","id":3,"customer_id":1000,"street":"58 Maryland Point","city":"Greensboro","state":"North Carolina","zip":"27404","type":"LIVING"}
{"ROWTIME":1558519823351,"ROWKEY":"null","id":4,"customer_id":1002,"street":"55795 Derek Avenue","city":"Temple","state":"Texas","zip":"76505","type":"LIVING"}
{"ROWTIME":1558519823351,"ROWKEY":"null","id":5,"customer_id":1002,"street":"164 Continental Plaza","city":"Modesto","state":"California","zip":"95354","type":"SHIPPING"}
{"ROWTIME":1558519823351,"ROWKEY":"null","id":6,"customer_id":1004,"street":"6 Miller Road","city":"Louisville","state":"Kentucky","zip":"40205","type":"BILLING"}
{"ROWTIME":1558519823351,"ROWKEY":"null","id":7,"customer_id":1003,"street":"97 Shasta Place","city":"Pittsburgh","state":"Pennsylvania","zip":"15286","type":"BILLING"}
{"ROWTIME":1558519823351,"ROWKEY":"null","id":8,"customer_id":1000,"street":"36 Warbler Circle","city":"Memphis","state":"Tennessee","zip":"38109","type":"SHIPPING"}
{"ROWTIME":1558519823351,"ROWKEY":"null","id":9,"customer_id":1001,"street":"890 Eagan Circle","city":"Saint Paul","state":"Minnesota","zip":"55103","type":"SHIPPING"}
{"ROWTIME":1558519823354,"ROWKEY":"null","id":10,"customer_id":1000,"street":"8 Judy Terrace","city":"Washington","state":"District of Columbia","zip":"20456","type":"SHIPPING"}
^C
Topic printing ceased

ksql>
ksql> PRINT 'customers' FROM BEGINNING;
Format:JSON
{"ROWTIME":1558519852363,"ROWKEY":"null","id":1001,"first_name":"Jolee","last_name":"Handasyde","email":"jhandasyde0@nhs.uk"}
{"ROWTIME":1558519852363,"ROWKEY":"null","id":1002,"first_name":"Rebeca","last_name":"Kerrod","email":"rkerrod1@sourceforge.net"}
{"ROWTIME":1558519852363,"ROWKEY":"null","id":1003,"first_name":"Bobette","last_name":"Brumble","email":"bbrumble2@cdc.gov"}
{"ROWTIME":1558519852368,"ROWKEY":"null","id":1004,"first_name":"Royal","last_name":"De Biaggi","email":"rdebiaggi3@opera.com"}