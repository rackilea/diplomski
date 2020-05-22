findAndHookMethod("com.android.internal.widget.LockPatternUtils", lpparam.classLoader, "checkPattern", List.class /*You need to name the attribute's data type, I'm still not sure if List.class is enough, as the type is List<LockPatternView.Cell>*/, new XC_MethodHook() {
@Override
        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
            List<?> pattern = param.args[0];
            // Proceed…
        }
});