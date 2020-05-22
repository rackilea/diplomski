$ curl -i "http://zsuzsafodraszat.hostzi.com/boltok.json"
HTTP/1.1 200 OK
Date: Wed, 13 Apr 2016 22:52:50 GMT
Server: Apache
Last-Modified: Wed, 13 Apr 2016 16:48:23 GMT
Accept-Ranges: bytes
Content-Length: 1020
Connection: close
Content-Type: application/json

??{"Aldi":"http://catalog.aldi.com/emag/hu_HU/print/Online_katalogus_04_07/Online_katalogus_04_07.pdf",
"Lidl":"http://www.lidl.hu/statics/lidl-hu/ds_doc/HU_HHZ_kw14_2016.pdf",
"Spar":"http://ajanlatok.spar.hu/view/download/?d=1279",
"Penny":"https://view.publitas.com/16538/136265/pdfs/016f82fb5b00bc97b5a8c35f512d89b01cd3e3ce.pdf",
"Coop":"https://view.publitas.com/2556/133497/pdfs/16603d7e9bf30e8a8a4efec7f01d3fa2caf92fe0.pdf",
"Auchan":"http://www.lidl.hu/statics/lidl-hu/ds_doc/HU_HHZ_kw14_2016.pdf"}

$ curl -i "https://api.myjson.com/bins/3zm8i"            
HTTP/1.1 200 OK
Server: nginx/1.5.8
Date: Wed, 13 Apr 2016 22:52:56 GMT
Content-Type: application/json
Content-Length: 500
Connection: keep-alive
Access-Control-Allow-Origin: *
Access-Control-Allow-Credentials: true

{"Aldi":"http://catalog.aldi.com/emag/hu_HU/print/Online_katalogus_04_07/Online_katalogus_04_07.pdf","Lidl":"http://www.lidl.hu/statics/lidl-hu/ds_doc/HU_HHZ_kw14_2016.pdf","Spar":"http://ajanlatok.spar.hu/view/download/?id=1279","Penny":"https://view.publitas.com/16538/136265/pdfs/016f82fb5b00bc97b5a8c35f512d89b01cd3e3ce.pdf","Coop":"https://view.publitas.com/2556/133497/pdfs/16603d7e9bf30e8a8a4efec7f01d3fa2caf92fe0.pdf","Auchan":"http://www.lidl.hu/statics/lidl-hu/ds_doc/HU_HHZ_kw14_2016.pdf"}