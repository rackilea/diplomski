ebean.distantdatabase="models.distantdatabase.*"
play.evolutions.db.distantdatabase.enabled=true
play.evolutions.db.distantdatabase.autoApply = true
db = {
  saetr {
    driver=com.mysql.jdbc.Driver
    url="jdbc:mysql://localhost/distantdatabase"
    username=play
    password=framework
  }
}