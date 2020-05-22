cqlsh:kunderatest> describe TABLE event ;

CREATE TABLE event (
  id text,
  log text,
  timstamp bigint,
  PRIMARY KEY (id)
)