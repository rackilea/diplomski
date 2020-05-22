private void log(String text) {
    Log.d("LifeCycleT", text);
    builde.append("\n");
    builde.append(text);
    textview.setText(builde.toString());
}