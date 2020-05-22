server {
    listen 80;
    location /spring/ {
        proxy_pass http://localhost:8080/home/;
    }
}