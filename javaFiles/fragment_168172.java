public static AlertDialog showProgressBar(Context context){
    AlertDialog.Builder builder = new AlertDialog.Builder(context);
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.layout_custom_progress_bar, null);
    builder.setView(view);
    AlertDialog dialog = builder.create();
    dialog.show();
    return dialog;
}