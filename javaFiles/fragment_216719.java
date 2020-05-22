sqlContext.udf().register("stringToLong", new UDF1<String, Long>() {

        @Override
        public Long call(String arg0) throws Exception {
            // TODO Auto-generated method stub
            IPTypeConvert itc = new IPTypeConvert();
            return itc.stringtoLong(arg0);
        }
    }, DataTypes.LongType);
DataFrame interDF = initInterDF.withColumn("interIPInt", callUDF("stringToLong", initInterDF.col("interIP")));