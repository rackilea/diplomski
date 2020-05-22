if (asynclass.getStatus() == android.os.AsyncTask.Status.PENDING) {
                asynclass.execute();
            } else if (RF.getStatus() == android.os.AsyncTask.Status.FINISHED) {
                asynclass = new asyncclass();
                asynclass.execute();
            } else {
                Toast.maketoast(this, "Plz wait", 1).show();
            }