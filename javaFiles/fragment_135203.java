08-06 14:38:59.148: I/System.out(3139): DEBUG IMAP: Can't load SASL authenticator: java.lang.ClassNotFoundException: com.sun.mail.imap.protocol.IMAPSaslAuthenticator
08-06 14:38:59.148: I/System.out(3139): DEBUG IMAP: LOGIN command trace suppressed
08-06 14:39:00.265: I/System.out(3139): DEBUG IMAP: LOGIN command result: * BYE [UNAVAILABLE] Temporary System Error
08-06 14:39:00.289: E/com.example.gmailandroid.MainActivity(3139): * BYE [UNAVAILABLE] Temporary System Error
08-06 14:39:00.289: E/com.example.gmailandroid.MainActivity(3139): javax.mail.MessagingException: * BYE [UNAVAILABLE] Temporary System Error;
08-06 14:39:00.289: E/com.example.gmailandroid.MainActivity(3139):   nested exception is:
08-06 14:39:00.289: E/com.example.gmailandroid.MainActivity(3139):  com.sun.mail.iap.ConnectionException: * BYE [UNAVAILABLE] Temporary System Error
08-06 14:39:00.289: E/com.example.gmailandroid.MainActivity(3139):  at com.sun.mail.imap.IMAPStore.protocolConnect(IMAPStore.java:668)