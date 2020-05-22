server {
    listen 8090;
    location /index {
        proxy_pass http://localhost:8080/home;
    }
}