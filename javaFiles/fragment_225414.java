public class LogsDialogFragment extends DialogFragment {

    private StringBuilder log = new StringBuilder();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Sets the Layout for the UI
        LayoutInflater i = getActivity().getLayoutInflater();
        View rootView = i.inflate(R.layout.fragment_logs_dialog, null);

        TextView logTextView = (TextView) rootView.findViewById(R.id.logTextView);
        logTextView.setMovementMethod(new ScrollingMovementMethod());

        try {
            Process process = Runtime.getRuntime().exec("logcat -d");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            StringBuilder log = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(WifiDirectHandler.LOG_TAG)){
                    // Removes log tag and PID from the log line
                    log.append(line.substring(line.indexOf(": ") + 2)).append("\n");
                }
            }

            this.log.append(log.toString().replace(this.log.toString(), ""));
            logTextView.setText(this.log.toString());
        } catch (IOException e) {
            Log.e("wifiDirectHandler", "Failure reading logcat");
        }

        // Creates and returns the AlertDialog for the logs
        AlertDialog.Builder dialogBuilder =  new  AlertDialog.Builder(getActivity())
            .setTitle(getString(R.string.title_logs))
            .setNegativeButton(getString(R.string.action_close),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.dismiss();
                    }
                }
            ).setView(rootView);
        return dialogBuilder.create();
    }
}