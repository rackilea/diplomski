Long objectLong = 555l;
long primitiveLong = 555l;

// This unboxing is compiler-generated due to numeric promotion
long tmpLong = objectLong.longValue();

System.out.println(tmpLong == primitiveLong);