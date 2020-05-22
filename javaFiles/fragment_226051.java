import java.util.Properties
import org.apache.spark.rdd.JdbcRDD
import java.sql.{Connection, DriverManager, ResultSet}
import org.apache.spark.implicits.

val url = "jdbc:mysql://mysql-rfam-public.ebi.ac.uk:4497/Rfam"
val username = "rfamro"
val password = ""
val myRDD = new JdbcRDD( sc, () => DriverManager.getConnection(url, username, password), "select rfam_id, noise_cutoff from family limit ?, ?", 1, 100, 10,                  
                    r => r.getString("rfam_id") + ", " + r.getString("noise_cutoff"))
val DF = myRDD.toDF
DF.show