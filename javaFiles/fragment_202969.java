...
// this is your preferred flag
private static final int _ReqCreatePattern = 0;

...

Intent intent = new Intent(context, LockPatternActivity.class);
intent.putExtra(LockPatternActivity._Mode, LockPatternActivity.LPMode.CreatePattern);
startActivityForResult(intent, _ReqCreatePattern);