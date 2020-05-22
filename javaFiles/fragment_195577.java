// int parameter can be int or Integer
public static BigInteger multiply ( int a, BigInteger b ) {
   return BigInteger.valueOf( a ).multiply( b );
}

// BigInteger <> BigDecimal
public static BigDecimal multiply ( int a, BigDecimal b ) {
   return BigDecimal.valueOf( a ).multiply( b );
}

// same for add, subtract, divide, mod etc.