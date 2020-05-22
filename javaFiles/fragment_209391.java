Dialog dialog = new Dialog(this);
dialog.setContentView(R.layout.dialog);
dialog.setTitle("Set size!");
dialog.setCancelable(true);
//there are a lot of settings, for dialog, check them all out!
dialog.show();

seekbar = (SeekBar) dialog.findViewById(R.id.size_seekbar);
final TextView tv_dialog_size = (TextView) dialog.findViewById(R.id.set_size_help_text);

// and you can call seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
      //implement methods.
}