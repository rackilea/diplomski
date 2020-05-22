if (response.body().getData().size() > 0) {
                    seen.clear();// change here
                    for (Datum datum : response.body().getData()) {
                        //Set not seen
                        if (!datum.getNotified()) {

                            seen.add(datum);
                            Log.e("Notification", "MAIN notified : " + datum.getNotified());
                    }