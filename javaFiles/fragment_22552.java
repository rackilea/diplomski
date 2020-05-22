@Query(value="SELECT * from (SELECT ROW_NUMBER() OVER (ORDER BY users.num) as RN, users.num, users .l_service,service.type_service, users.date, " +
    "chambre.price," +
    "price* ( case when(datediff(day,date_d,date_f)=0) then 1 " +
    "else datediff(day,date_d,date_f) end ) as Montant," +
    "case when  (service.type_service='R') and  datediff(day,date_d,date_f) >=21 " +
    "then (21300+(datediff(day,date_d,date_f)-21)*200)" +
    "else price*(case when(datediff(day,date_d,date_f)=0) then 1 else datediff(day,date_d,date_f)end) end AS Montant_final " +
    " users.year, users.Etat, " +
    " from chambre JOIN users ON chambre.code = users.type " +
    "JOIN service on service.code = users.l_service " +
    " WHERE users.Etat='V') AS STA where RN between ?#{ #pageable.offset -1} and ?#{#pageable.offset + #pageable.pageSize} order by STA.num",
    countQuery ="select count(*) from users ",nativeQuery = true) 
    Page<Object> getStatistiques(Pageable pageable);