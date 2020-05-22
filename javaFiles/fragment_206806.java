SELECT guid 
FROM wp_posts AS a 
INNER JOIN ( 
    SELECT meta_value 
    FROM wpsys_postmeta AS b 
    INNER JOIN ( 
        SELECT ID FROM 
        wpsys_posts 
        WHERE post_type = 'post' 
        AND post_status = 'publish' 
        ORDER BY post_date 
        DESC LIMIT 3 ) AS tbl1 
    ON b.post_id = tbl1.ID and b.meta_key='_thumbnail_id' ) as tbl2 
ON a.ID = tbl2.meta_value;