SELECT (xpath('./@photo_id', c.node))[1] AS photo_id
     , unnest(xpath('./comment/text()', c.node)) AS descriptor
FROM  (             
    SELECT unnest(xpath('./comments', x)) AS node
    FROM   t
    ) c;