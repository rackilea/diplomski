dialog.setOnCancelListener(dialogInterface -> {
            Log.d(TAG, "Dialog canceled!");
        });
        dialog.setOnDismissListener(dialogInterface -> {
            Log.d(TAG, "Dialog dismissed!");
        });