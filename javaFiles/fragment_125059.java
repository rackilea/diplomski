final Context context = Context.enter();
try {
  final ScriptableObject scope = context.initStandardObjects();
  scope.defineFunctionProperties(
          new String[] {"defineClass"},
          Global.class,
          ScriptableObject.DONTENUM);

  context.evaluateString(scope, script, "script", 1, null);
  // etc.
} finally {
  Context.exit();
}