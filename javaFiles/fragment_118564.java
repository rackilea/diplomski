-- foo.pig
ids = load '$INPUT' as (id: int);
ids_with_key = foreach ids generate (id - $MIN) * $BIN_COUNT / ($MAX- $MIN + 1) as bin_id, id;
group_by_id = group ids_with_key by bin_id;
bin_id = foreach group_by_id generate group, flatten(ids_with_key.id);
dump bin_id;