return em.createNativeQuery("SELECT  peoplecounting.result.date_time, GREATEST(sum(peoplecounting.result.count_up - peoplecounting.result.count_down) " +
            "OVER (PARTITION BY date_trunc('day', peoplecounting.result.date_time) " +
            "ORDER BY peoplecounting.result.date_time),0) AS cum_amt" +
            " FROM   peoplecounting.result" +
            " order  BY peoplecounting.result.date_time",
            "TotalResultMapping").getResultList();