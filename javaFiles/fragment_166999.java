String enumClassName = "com.mycompany.MyEnum";
String enumConstant = "MyValue";

Class enumClass = Class.forName(enumClassName);
Object enumValue = Enum.valueOf(enumClass, enumConstant);

assert enumValue == MyEnum.MyValue; // passes