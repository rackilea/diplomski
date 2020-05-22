public static void setFloatOrNull(PreparedStatement ps, int index, Float value) {
    if (value == null) {
        ps.setNull(index, Types.FLOAT);
    } else {
        ps.setFloat(index, value);
    }
}