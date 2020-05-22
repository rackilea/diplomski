SELECT post_title, post_content, post_date
FROM wp_posts 
WHERE post_type='post' 
AND post_status='publish' 
ORDER BY post_date 
DESC LIMIT 3;