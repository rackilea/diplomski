<update id="update">
UPDATE
myTable
   <set>
        ...
       <if test="myField != null">myField = #{myField ,typeHandler=YesNoBooleanTypeHandler}</if>
        ...
    </set>
 WHERE
    ...
 </update>