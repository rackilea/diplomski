user www-data;
worker_processes 4;
pid /var/run/nginx.pid;

events {
    worker_connections 4096;
    # multi_accept on;
}

http {

    server {
        listen 80; #incoming port for nginx
        server_name localhost;
        location / {
            proxy_pass http://127.0.0.1:8080;
        }
    }

#...and other things, like basic settings, logging, mail, etc.