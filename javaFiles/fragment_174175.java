upstream webservices {
    server 10.0.0.1:80;
    server 10.0.0.2:80;
    server 10.0.0.3:80;
}
server {
    ... default nginx stuff ...
    location /dynamic_content {
          memcached_pass localhost:11211;
          default_type   text/html;
          error_page     404 502 = @dynamic_content_cache_miss;
          set $memcached_key $uri;
    }
    location @dynamic_content_cache_miss {
          proxy_pass http://webservices;
    }