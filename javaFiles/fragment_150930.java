try {
    Calculator calc = (Calculator) context;
} catch (ClassCastException e) {
    Log.e("Log Tag", context.toString() + " must inherit from Calculator class");
    e.printStackTrace();
}