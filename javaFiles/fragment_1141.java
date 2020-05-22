<select id="getUser" parameterType="String"resultType="post.User"> 
select * from users where    
          <foreach item="item" collection="user_login_map.entrySet()" separator="OR">
        (user_email=#{item.key} AND user_password=#{item.value})
        </foreach>
</select>