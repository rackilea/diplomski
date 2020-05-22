private static final Map<Currency, DecimalFormat> SYMBOL2FMT
    = new EnumMap<>(Currency.class) {{
    for (Currency c : Currency.values()) {
        put(c, new DecimalFormat("###,###.### " + c.getSymbol()));
    }
}};