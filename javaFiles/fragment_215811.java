int curScore;
...
Intent resp = new Intent();
resp.putExtra("score", curScore);
setResult(1, resp);
finish();