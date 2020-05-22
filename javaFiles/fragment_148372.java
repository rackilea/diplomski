try {
        cl = ((MainActivity) getActivity()).clipboardManager();
        cl.setPrimaryClip(ClipData.newPlainText("copy", data));
        copyToast.show();
    } catch (NullPointerException e) {
        e.printStackTrace();
        Log.e(TAG, "Could not copy data: NullPointerException");
        copyToast = Toast.makeText(context, getString(R.string.null_text), Toast.LENGTH_LONG);
        copyToast.show();
    }