query.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> eventList, ParseException e) {
                    if (e == null) {
                        // If there are results, update the list of event and notify the adapter
                        Log.d(TAG, "Im in background"); //im able to display image
                        eventList.clear();
                        for (ParseObject event : eventList) {
                            eventList.add(event);
                        }

                        updateEventsList();

                    } else {