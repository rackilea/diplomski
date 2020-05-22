- add somewhere a file called krb5.conf with inside :

[libdefaults]
default_realm = YOUR_REALM
default_tkt_enctypes = arcfour-hmac-md5
default_tgs_enctypes = arcfour-hmac-md5
permitted_enctypes = arcfour-hmac-md5

dns_lookup_kdc = true
dns_lookup_realm = false

[realms]
YOUR_REALM = {
kdc = KERBEROS_SERVER
default_domain = YOUR_REALM
}