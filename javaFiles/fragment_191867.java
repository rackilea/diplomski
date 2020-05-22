server {
    listen 80 default_server;
    server_name myprod.com;
    location /example-microservice-1 {
        proxy_pass http://localhost:8001;
        proxy_set_header Host      $host;
        proxy_set_header X-Real-IP $remote_addr;
    }
    location /example-microservice-2 {
        proxy_pass http://localhost:8002;
        proxy_set_header Host      $host;
        proxy_set_header X-Real-IP $remote_addr;
    }
}