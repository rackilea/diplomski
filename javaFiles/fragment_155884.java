// --- TEST ASYNC STATUS ---
while(dit != null) {

    if(dit.getStatus() == AsyncTask.Status.FINISHED) {
        Log.i("ASYNC", "END2!!");
        break;
    }
    else {
        Log.w("ASYNC WAITING", dit.getStatus().toString());
    }
}

// --- END TEST ASYNC STATUS ---

return bmp;