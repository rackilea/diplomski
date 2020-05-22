aploetz@cqlsh:stackoverflow2> SELECT token(event_uuid),document_uuid FROM document_change_events WHERE token(event_uuid) > token(minTimeuuid('2015-05-10 00:00-0500')) AND token(event_uuid) < token(maxTimeuuid('2015-05-22 00:00-0500'));

 token(event_uuid)    | document_uuid
----------------------+--------------------------------------
 -2112897298583224342 | a079b30f-be80-4a99-ae0e-a784d82f0432
  2990331690803078123 | 3b593ca6-220c-4a8b-8c16-27dc1fb5adde
  5049638908563824288 | ec155e0b-39a5-4d2f-98f0-0cd7a5a07ec8
  5577339174953240576 | db42271b-04f2-45d1-9ae7-0c8f9371a4db

(4 rows)