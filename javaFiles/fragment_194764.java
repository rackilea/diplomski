location /site1/ {
        proxy_pass http://localhost:8081/;
    }

    location /site2/ {
        proxy_pass http://localhost:8080/;
    }