@Repository
interface InterventionRepository : JpaRepository<Intervention, Long> {

@Query("select new Intervention(i.id, i.date, i.wishedDate, a.name) " +
        "from Intervention i " +
        "inner join i.address a ")
fun getInterventions(): Optional<ArrayList<Intervention>>
}