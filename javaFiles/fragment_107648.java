KafkaClient {
 com.sun.security.auth.module.Krb5LoginModule required
 doNotPrompt=true
 useTicketCache=true
 principal="ctadmin@HSCALE.COM"
 useKeyTab=true
 serviceName="kafka"
 keyTab="/etc/security/keytabs/ctadmin.keytab"
 client=true;
};