server {
    listen       80;
    server_name  example.com;

    location ~ ^/(WEB-INF)/ {
        deny all;
    }

    location ~* ^.+.(css|js|jpeg|jpg|gif|png|ico|svg|eof|otf|ttf|woff) {
        root               /usr/local/tomcat/webapps/AppName/;
        expires            24h;
        access_log         off;
    }

    location / {
        proxy_pass         http://127.0.0.1:8080;
    }
}