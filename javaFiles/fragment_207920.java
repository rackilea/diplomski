UPDATE
<set>
      <if test="amount!= null">amount=#{amount},</if>
      <if test="name!= null">name=#{name},</if>
      <if test="balanceTime!= null">balanceTime=#{balanceTime} </if>
</set>
WHERE number=#{number} AND clientId=#{clientId}