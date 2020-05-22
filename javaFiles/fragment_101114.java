groovy:000> import java.sql.*
===> [import java.sql.*]
groovy:000> Class.forName("org.postgresql.Driver");
===> class org.postgresql.Driver
groovy:000> db = DriverManager.getConnection("jdbc:postgresql:janko", "janko", "qwertz");
===> org.postgresql.jdbc4.Jdbc4Connection@3a0b2c64
groovy:000> ps = db.prepareStatement("SELECT image FROM blobtest2 WHERE name = ?");
===> SELECT image FROM blobtest2 WHERE name = ?
groovy:000> ps.setString(1, "somebinary")
===> null
groovy:000> rs = ps.executeQuery()
===> org.postgresql.jdbc4.Jdbc4ResultSet@66f9104a
groovy:000> rs.next()
===> true
groovy:000> rs.getBlob("image")
ERROR org.postgresql.util.PSQLException: Bad value for type long : \336\255\276\357\336\255\276\357
        at org.postgresql.jdbc2.AbstractJdbc2ResultSet.toLong (AbstractJdbc2ResultSet.java:2796)
        at org.postgresql.jdbc2.AbstractJdbc2ResultSet.getLong (AbstractJdbc2ResultSet.java:2019)
        at org.postgresql.jdbc4.Jdbc4ResultSet.getBlob (Jdbc4ResultSet.java:52)
        at org.postgresql.jdbc2.AbstractJdbc2ResultSet.getBlob (AbstractJdbc2ResultSet.java:335)
        at groovysh_evaluate.run (groovysh_evaluate:3)
        ...