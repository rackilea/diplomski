class Generic<T> {

    public final Class<T> type;

    public Generic(Class<T> type) {
        this.type = type;
    }

    public Class<T> type() {
        return type;
    }
}

class Main {
    public static void main(String[] args) {

        final Generic<Integer> gint2 = new Generic<>(Integer.class);
        System.err.println("gint2's type-parameter: " + gint2.type().getSimpleName());
    }
}
// Output will be "gint2's type-parameter: Integer".