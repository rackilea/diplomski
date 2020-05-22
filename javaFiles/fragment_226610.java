public void SaveMessage(Context context, String message) {

    FileOutputStream FoutS = null;
    OutputStreamWriter outSW = null;

    try {
        FoutS = context.openFileOutput("Message.dat", Context.MODE_PRIVATE);

        // Rest of try block here
    }
    // 'catch' and 'finally' here
}