private static Double getNumber(Object in, int type) {
    if (in == null)
      return 0d;
    switch (type) {
      case BIG_DECIMAL:
        return ((Number) in).doubleValue();
      case DataTypes.BIG_INTEGER:
        return ((Number) in).doubleValue();
      case DataTypes.INTEGER:
      case DataTypes.W_INTEGER:
        return ((Number) in).doubleValue();
      case DataTypes.LONG:
      case DataTypes.W_LONG:
        return ((Number) in).doubleValue();
      case DataTypes.STRING:
        return Double.parseDouble((String) in);
      case DataTypes.FLOAT:
      case DataTypes.W_FLOAT:
        return ((Number) in).doubleValue();
      case DataTypes.DOUBLE:
      case DataTypes.W_DOUBLE:
        return (Double) in;
      case DataTypes.SHORT:
      case DataTypes.W_SHORT:
        return ((Number) in).doubleValue();
      case DataTypes.CHAR:
      case DataTypes.W_CHAR:
        return Double.parseDouble(String.valueOf((Character) in));
      case DataTypes.BOOLEAN:
      case DataTypes.W_BOOLEAN:
        return ((Boolean) in) ? 1d : 0d;
      case DataTypes.W_BYTE:
      case DataTypes.BYTE:
        return ((Byte) in).doubleValue();
    }

    throw new RuntimeException("cannot convert <" + in + "> to a numeric type: " + in.getClass() + " [" + type + "]");

}