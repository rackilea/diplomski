SELECT u1.usr  || '-' || u2.usr, count(*) AS ct
FROM   usr_grp t1
JOIN   usr_grp t2 USING (grp_id) 
JOIN   usr u1 ON t1.usr_id = u1.usr_id
JOIN   usr u2 ON t2.usr_id = u2.usr_id
WHERE  t2.usr_id > t1.usr_id
GROUP  BY u1.usr_id, u2.usr_id;