dev> alter java class "com/sun/xml/messaging/saaj/soap/MessageFactoryImpl" resolve;
dev> /

Warning: Java altered with compilation errors.

dev> show error
Errors for JAVA CLASS "/3e484eb0_MessageFactoryImpl":

LINE/COL ERROR
-------- -----------------------------------------------------------------
0/0      ORA-29521: referenced name javax/xml/soap/MessageFactory could
         not be found

0/0      ORA-29521: referenced name javax/xml/soap/SOAPMessage could not
         be found

0/0      ORA-29521: referenced name javax/xml/soap/MimeHeaders could not
         be found

0/0      ORA-29521: referenced name javax/xml/soap/SOAPException could not
         be found