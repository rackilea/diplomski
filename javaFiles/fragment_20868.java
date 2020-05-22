SELECT *
  FROM user
 WHERE user.user_id != 1
   AND user.user_id NOT IN
        ( SELECT frnd.frnd_id
            FROM frnd
           WHERE user_id = 1
        )
   AND user.name LIKE '%rah%'
;