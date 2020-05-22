select distinct *
from item
join tag on tag.item_id = item.id
where item.name = 'foo'
and tag.name != 'tag3'
and item.id in (select item_id from tag where name = 'tag3');