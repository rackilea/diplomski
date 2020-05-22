// send web request to the webserver
    fprintf(&modem,"POST /MyService/addnums HTTP/1.1\n\
    Host: 10.8.155.16:8080\n\
    Content-Type: text/html\n\
    Content-length:6\n\n\
    10,100\
    %c",26);