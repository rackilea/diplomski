final Context context = Context.enter();
try {
  final ScriptableObject scope = context.initStandardObjects();
  ScriptableObject.defineClass(scope, Target.class, false, true);
  context.evaluateString(scope, script, "script", 1, null);
  // etc.
} finally {
  Context.exit();
}