[libdefaults]
    default_realm = ABC.MYCOMPANY.COM
    default_keytab_name = FILE:C:\IBM\WebSphere\AppServer\kerberos\MyServer.keytab
    default_tkt_enctypes = rc4-hmac des-cbc-md5
    default_tgs_enctypes = rc4-hmac des-cbc-md5
    permitted_enctypes = rc4-hmac des-cbc-md5
    forwardable  = true
    renewable  = true
    noaddresses = true
    clockskew  = 300
[realms]
    ABC.MYCOMPANY.COM = {
        kdc = TEST.abc.mycompany.com:88
        default_domain = abc.mycompany.com
    }
[domain_realm]
    .abc.mycompany.com = ABC.MYCOMPANY.COM
   abc.mycompany.com = ABC.MYCOMPANY.COM