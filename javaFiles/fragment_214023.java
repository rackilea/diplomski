public static void main(String args[])
    {
        System.out.println("=========================Salesforce Ingest Begins=========================");
        SparkSession spark = SparkSession.builder().getOrCreate();

        Dataset<Row> df = spark.read().format("com.springml.spark.salesforce")
                    .option("username", "someuser@someDomain")
                    .option("password", "mypasswordMYSECURITYTOKEN")
                    .option("login", "https://login.salesforce.com/login/page")
                    .option("soql", "SELECT id from myTable")
                    .option("version", "37.0")
                    .load();

        df.show(false);

        spark.close();
        System.out.println("=========================Salesforce Ingest ENDS=========================");
    }