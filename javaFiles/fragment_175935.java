UserDefinedFunction my_udf2 = udf(
    (WrappedArray<String> s1, WrappedArray<String> s2) -> "some_string",
    DataTypes.StringType
);

df.select(my_udf2.apply(col("a1"), col("a2")).show(false);