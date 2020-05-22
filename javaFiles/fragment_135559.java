@GrabConfig(systemClassLoader=true)
@Grab('org.xerial:sqlite-jdbc:3.6.16')
import org.sqlite.*
import java.sql.*

db = groovy.sql.Sql.newInstance("jdbc:sqlite::memory:","org.sqlite.JDBC")

// a distance function using the spherical law of cosines
Function.create(db.getConnection(), "distance", new Function() {
    protected void xFunc() throws SQLException {
        def lat1 = value_double(0)
        def lon1 = value_double(1)
        def lat2 = value_double(2)
        def lon2 = value_double(3)

        double theta = lon1 - lon2;
        double dist = (Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))) + 
            (Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta)))
        dist = Math.acos(dist)
        dist = rad2deg(dist)
        dist = dist * 60 * 1.1515
        dist = dist * 1.609344
        result(dist);
    }

    def deg2rad(deg) {
      deg * Math.PI / 180.0
    }

    def rad2deg(rad) {
      rad * 180.0 / Math.PI
    }
})

db.execute("CREATE TABLE city(name, lat, lon)")
db.execute("INSERT INTO city(name, lat, lon) VALUES('New York City', 40.7143, -74.0060)")
db.execute("INSERT INTO city(name, lat, lon) VALUES('San Francisco', 37.7749, -122.4194)")
db.execute("INSERT INTO city(name, lat, lon) VALUES('Paris', 48.8567, 2.3510)")
db.execute("INSERT INTO city(name, lat, lon) VALUES('Cologne', 50.9407, 6.9599)")

db.eachRow("SELECT a.name as a, b.name as b, distance(a.lat, a.lon, b.lat, b.lon) as d FROM city a, city b WHERE a.name != b.name ORDER BY d;") {
    println "Distance from ${it.a} to ${it.b}: ${it.d}km"
}