server {                                                         
  # this matches every subdomain of domain.
  server_name .domain;                                           

  location / {                                                   
    set $new_request_uri "";                                     
    set $subdomain "";

    if ($host ~* "^(.+)\.domain$") {                             
      set $subdomain $1;                                         
      # lets assume there are args...
      set $new_request_uri "$request_uri&subdomain=$subdomain";  
    }                                                            
    # if there are no args add a question mark and the subdomain argument
    if ($args = '') {                                            
      set $new_request_uri "$request_uri?subdomain=$subdomain";  
    }                                                            

    proxy_pass http://127.0.0.1:8080$new_request_uri;              
  }                                                              
}