<VirtualHost ipaddress:8443>
        # The ServerName directive sets the request scheme, hostname and port that
        # the server uses to identify itself. This is used when creating
        # redirection URLs. In the context of virtual hosts, the ServerName
        # specifies what hostname must appear in the request's Host: header to
        # match this virtual host. For the default virtual host (this file) this
        # value is not decisive as it is used as a last resort host regardless.
        # However, you must set it for any further virtual host explicitly.
        #ServerName www.example.com

        ServerAdmin webmaster@localhost
        DocumentRoot /var/www/html

        # Available loglevels: trace8, ..., trace1, debug, info, notice, warn,
        # error, crit, alert, emerg.
        # It is also possible to configure the loglevel for particular
        # modules, e.g.
        #LogLevel info ssl:warn

        ErrorLog ${APACHE_LOG_DIR}/error.log
        CustomLog ${APACHE_LOG_DIR}/access.log combined
<IfModule dir_module>
DirectoryIndex index.html
</IfModule>

        LogLevel debug
        #SetEnv HTTPS on
        SSLEngine on
        SSLCertificateFile /etc/ssl/certs/mydomain_co_uk.crt
        SSLCertificateKeyFile /etc/ssl/private/www.mydomain.co.uk.key
       # SSLCertificateKeyFile /etc/ssl/certs/mydomain_co_uk.pem
        SSLCACertificateFile /etc/ssl/certs/mydomain_co_uk.ca-bundle
        ServerName www.mydomain.co.uk
SSLProxyEngine on
    ProxyPass /MyProject/context https://www.mydomain.co.uk/MyProject/context 
    ProxyPassReverse /MyProject/context https://www.mydomain.co.uk/MyProject/context

Alias /ProjectName"/var/lib/tomcat8/webapps/ProjectName"


<Directory "/var/lib/tomcat8/webapps/ProjectName">
Options Indexes FollowSymLinks
AllowOverride all
Allow from all
</Directory>



<Location />
Require all granted
</Location>



        # For most configuration files from conf-available/, which are
        # enabled or disabled at a global level, it is possible to
        # include a line for only one particular virtual host. For example the
        # following line enables the CGI configuration for this host only
        # after it has been globally disabled with "a2disconf".
        #Include conf-available/serve-cgi-bin.conf
</VirtualHost>