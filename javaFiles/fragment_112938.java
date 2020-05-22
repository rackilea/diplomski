-- DROP TABLE t;
CREATE TEMP TABLE t (x xml);
INSERT INTO t VALUES (
'<tbl>
<comments photo_id="123">
     <comment>this is the first 123 comment</comment>
     <comment>this is the second 123 comment</comment>
</comments>
<comments photo_id="124">
     <comment>this is the first 124 comment</comment>
     <comment>this is the second 124 comment</comment>
     <comment>this is the third 124 comment</comment>
</comments>
</tbl>'::xml);