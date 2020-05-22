SELECT 
    _id, 
    shoplistdateadded, 
    date(substr(shoplistdateadded,1,10),'unixepoch') AS converted_date 
FROM shoplist;
SELECT 
    _id, 
    shoplistdateadded, 
    date(substr(shoplistdateadded,1,10),'unixepoch') AS converted_date 
FROM "shoplist" 
WHERE date(substr(shoplistdateadded,1,10),'unixepoch') 
    BETWEEN date('2019-04-01') 
        AND date('2019-04-30')
;