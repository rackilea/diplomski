@Test
public void parseResourceIdTest() {
    final Context context = InstrumentationRegistry.getTargetContext();

    assertEquals(R.id.btn_0, parseResourceId(context, "btn_0"));
}

public static int parseResourceId(@NonNull Context context, @NonNull String string) {
    return context.getResources().getIdentifier(string, "id", context.getPackageName());
}