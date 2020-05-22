CREATE TABLE document_change_events2 (
    event_uuid TIMEUUID,
    document_uuid uuid,
    month text,
    PRIMARY KEY ((month),event_uuid, document_uuid)
) WITH default_time_to_live='7776000';