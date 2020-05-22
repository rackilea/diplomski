public static <T, U> String getGenericMsg(List<T> genericList, Function<T, U> function) {
    StringBuilder msg = new StringBuilder();
    if (genericList != null) {
        for (T genericObject : genericList) {
            msg.append(function.apply(genericObject)).append(" ");
        }
    }
    return msg.toString().trim();
}


private static Function<State, String> STATE_TO_STRING = new Function<State, String>() {
    public String apply(State input) {
        return input.getStateCd();
    }
};

private static Function<Code, String> CODE_TO_STRING = new Function<Code, String>() {
    public String apply(Code input) {
        return input.getCd();
    }
};

private static Function<Country, String> COUNTRY_TO_STRING = new Function<Country, String>() {
    public String apply(Country input) {
        return input.getCountryCd();
    }
};