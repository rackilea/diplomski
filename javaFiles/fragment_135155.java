server {
    [...]
    if ( $ssl_protocol = TLSv1.1 ) {
        return 302 $scheme://NODE1.yourhost.com$request_uri;
    }
    if ( $ssl_protocol = TLSv1.2 ) {
        rewrite ^ $scheme://NODE2.yourhost.com$request_uri;
    }