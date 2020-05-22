public static void main(String[] args)
{
    System.out.println(getPrimitive("123")); // Byte
    System.out.println(getPrimitive("1233")); // Short
    System.out.println(getPrimitive("1233587")); // Integer
    System.out.println(getPrimitive("123.2")); // Float
    System.out.println(getPrimitive("123.999999")); // Double
    System.out.println(getPrimitive("12399999999999999999999999")); // BigInteger
    System.out.println(getPrimitive("123.999999999999999999999999")); // BigDecimal
}

static public Object getPrimitive(String string)
{
  try { return Byte.valueOf(string);       } catch (Exception e) { };
  try { return Short.valueOf(string);      } catch (Exception e) { };
  try { return Integer.valueOf(string);    } catch (Exception e) { };
  try { return new BigInteger(string);     } catch (Exception e) { };
  try { if (string.matches(".{1,8}"))
          return Float.valueOf(string);    } catch (Exception e) { };
  try { if (string.matches(".{1,17}"))
          return Double.valueOf(string);   } catch (Exception e) { };
  try { return new BigDecimal(string);     } catch (Exception e) { };
  // more stuff ?
  return null;
}