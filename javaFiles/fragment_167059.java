pgjdbc {
com.sun.security.auth.module.Krb5LoginModule required
refreshKrb5Config=true
doNotPrompt=true
useTicketCache=true
renewTGT=true
useKeyTab=true
keyTab="c:/<locationto>/<user>.keytab"
debug=true
client=true
principal="<user>@<domain>";