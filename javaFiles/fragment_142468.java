<update id="updateFactory" 
        parameterType="WorkOrder">
    UPDATE wo
    SET factory = '#{factory}'
    WHERE work_order = '#{work_order}'  
</update>