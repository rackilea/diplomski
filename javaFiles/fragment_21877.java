if (repo.getIsRsvpAvailable().equals("true")){
    rsvpButton.setVisibility(View.VISIBLE);
    if(mAllRSVPEventsList.size() != 0) {

        for (int i = 0; i < mAllRSVPEventsList.size(); i++) {
            if (mAllRSVPEventsList.get(i).getEvent().getEventId().equals(repo.getEventId()) && mAllRSVPEventsList.get(i).getIsAttending()) {
                rsvpButton.setText("CANCEL");
                rsvpButton.setTextColor(Color.parseColor("#647ed6"));
                mYesText.setVisibility(View.VISIBLE);
                rsvpButton.setBackgroundColor(Color.WHITE);
                GradientDrawable gd = new GradientDrawable();
                gd.setCornerRadius(2);
                gd.setGradientRadius(2);
                gd.setStroke(2, 0xFF647ed6);
                rsvpButton.setBackground(gd);
                rsvpButton.setOnClickListener(v -> {
                    Log.d("clickedbutton", "it is in" + repo.getTitle());
                    mCallback.onRSVPButtonClick(repo.getEventId(), position, "false", repo.getTitle(), rsvpButton, mAllRSVPEventsList);

                });
                break;
            }

            if (mAllRSVPEventsList.get(i).getEvent().getEventId().equals(repo.getEventId()) && !mAllRSVPEventsList.get(i).getIsAttending()) {

                rsvpButton.setText("RSVP");
                rsvpButton.setBackgroundColor(Color.parseColor("#647ed6"));
                rsvpButton.setTextColor(Color.WHITE);
                mYesText.setVisibility(View.GONE);

                rsvpButton.setOnClickListener(v -> {

                    mCallback.onRSVPButtonClick(repo.getEventId(), position, "true", repo.getTitle(), rsvpButton, mAllRSVPEventsList);

                });
                break;
            } else {
                rsvpButton.setText("RSVP");
                rsvpButton.setBackgroundColor(Color.parseColor("#647ed6"));
                rsvpButton.setTextColor(Color.WHITE);
                mYesText.setVisibility(View.GONE);
                rsvpButton.setOnClickListener(v -> {
                    mCallback.onRSVPButtonClick(repo.getEventId(), position, "true", repo.getTitle(), rsvpButton, mAllRSVPEventsList);

                });
            }


        }
    } else {
        for (int i = 0; i < mEventListResponseList.size(); i++) {
            rsvpButton.setOnClickListener(v -> {
                mCallback.onRSVPButtonClick(repo.getEventId(), position, "true", repo.getTitle(), rsvpButton, mAllRSVPEventsList);

            });
        }
    }
}