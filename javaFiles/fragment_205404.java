import scala.collection.JavaConversions;
import scala.collection.Seq;

import static java.util.Arrays.asList;

DataFrame interDF = initInterDF.withColumn("interIPInt", 
    callUDF("stringToLong", JavaConversions.asScalaBuffer(asList(initInterDF.col("interIP")))));