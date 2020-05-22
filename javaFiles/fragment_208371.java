dev> select object_name, dbms_java.longname(object_name),status
  2  from user_objects
  3  where object_name like '%MessageFactoryImpl';

OBJECT_NAME
--------------------------------------------------------------------------------
DBMS_JAVA.LONGNAME(OBJECT_NAME)
--------------------------------------------------------------------------------
STATUS
-------
/3e484eb0_MessageFactoryImpl
com/sun/xml/messaging/saaj/soap/MessageFactoryImpl
INVALID