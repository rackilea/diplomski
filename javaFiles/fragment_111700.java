@Query(value = 
    "cast(d.DATA as Date) as naDzien, pt.POKOJTYP_ID as pokojtypId, pt.POKOJTYP_NAZWA as pokojtypNazwa, 10 as ileDostepnych \n" +
    "from LISTADAT(:data_od, :data_do) d \n" +
    "left join POKOJTYP pt on 1=1 \n" +
    "order by d.DATA, pt.POKOJTYP_NAZWA",
    nativeQuery = true)
List<DostepnoscTypyListProjection> getDostepnoscNaTypy(
        @Param("data_od") Date dataOd,
        @Param("data_do") Date dataDo);