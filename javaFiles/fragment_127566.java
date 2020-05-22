import tables.Tables

class SeparateClass extends HasDatabaseConfig[JdbcProfile] {
  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  import driver.api._

  def get(id: Long) = {
    db.run(Tables.DrugEffect.d_effects.filter(_.id === id).result)
  }
}