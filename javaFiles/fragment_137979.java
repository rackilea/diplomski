ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
                        public void onRatingChanged(RatingBar ratingBar,
                                float rating, boolean fromUser) {
                            String answerValue = String
                                    .valueOf((int) (ratingBar.getRating()));
                        }
                    });