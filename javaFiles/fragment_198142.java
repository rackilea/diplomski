UDF1 checkNumeric = new UDF1<String, Boolean>() {
        public Boolean call(final String account) throws Exception {
            return StringUtils.isNumeric(account);
        }
    };

    sqlContext.udf().register("numeric", checkNumeric, DataTypes.BooleanType);