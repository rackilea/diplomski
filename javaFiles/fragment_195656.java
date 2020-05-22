BEGIN
DBMS_AQADM.CREATE_QUEUE_TABLE(
queue_table            => 'QT3',
queue_payload_type     => 'SYS.AQ$_JMS_TEXT_MESSAGE',
compatible => '8.1.0');
END;
/