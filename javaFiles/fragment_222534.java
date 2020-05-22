aploetz@cqlsh:stackoverflow2> SELECT document_uuid FROM document_change_events2 
WHERE month='201505'
  AND event_uuid > minTimeuuid('2015-05-10 00:00-0500')
  AND event_uuid < maxTimeuuid('2015-05-22 00:00-0500');

 document_uuid
--------------------------------------
 a079b30f-be80-4a99-ae0e-a784d82f0432
 ec155e0b-39a5-4d2f-98f0-0cd7a5a07ec8
 db42271b-04f2-45d1-9ae7-0c8f9371a4db
 92b6fb6a-9ded-47b0-a91c-68c63f45d338
 11b4a49c-b73d-4c8d-9f88-078a6f303167
 970e5e77-1e07-40ea-870a-84637c9fc280
 3b593ca6-220c-4a8b-8c16-27dc1fb5adde
 c8188b73-1b97-4b32-a897-7facdeecea35
 548b320a-10f6-409f-a921-d4a1170a576e
 b29e7915-7c17-4900-b784-8ac24e9e72e2

(10 rows)