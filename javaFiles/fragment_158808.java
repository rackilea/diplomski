server {

        listen 80;
        server_name example.test;

        root /your/directory/path/files;

        access_log /var/log/nginx/test_access.log;
        error_log /var/log/nginx/test_error.log;

        location ~ \.(js|html) {
            include cors.conf;
            try_files $uri =404;
        }


}