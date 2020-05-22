public static BigInteger valueOf(long val) 
{
         if (val == 0)
             return ZERO;

         if (val > 0 && val <= MAX_CONSTANT)
             return posConst[(int) val];

         else if (val < 0 && val >= -MAX_CONSTANT)
             return negConst[(int) -val];

         return new BigInteger(val);
}