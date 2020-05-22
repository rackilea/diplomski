//jaas-krb5.conf
anything {
    com.sun.security.auth.module.Krb5LoginModule required
    useKeyTab=true
    storeKey=true
    doNotPrompt=true
    keyTab="/home/myusr/my-server.keytab"
    principal="myserv/mymachine.some.domain";
};