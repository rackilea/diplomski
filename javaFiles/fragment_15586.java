<insert id="savePayments">
   INSERT ALL
   <foreach collection="payments" item="payment">
   INTO
      mass_payments_t (payment_id, file_id, msisdn, amount)
   VALUES
      (seq_mass_payment.nextval, #{payment.fileId, javaType=Integer, jdbcType=NUMERIC}, #{payment.msisdn, javaType=String, jdbcType=VARCHAR}, #{payment.amount, javaType=BigDecimal, jdbcType=NUMERIC})
   </foreach>
   SELECT * FROM dual
</insert>