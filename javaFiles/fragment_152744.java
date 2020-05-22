int counterInt; // as a global variable



counterInt = Integer.parseInt(editTextNOI.getText().toString()); // in onCreate()



 public void poslijeDelaya(final int count) {

                if (counterInt > 0) {


                    String tekstTrci = editTextHIIVrijeme.getText().toString();
                    long longTrci = Long.parseLong(tekstTrci);

                    textViewRundiPreostalo.setText(Integer.toString(counterInt));
                    CountDownTimer timerTrci = new CountDownTimer(longTrci * 1000 + 100, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            updateTimer((int) millisUntilFinished / 1000);

                        }

                        @Override
                        public void onFinish() {
                            textViewGlavniTimer.setText("00:00");
                            imageViewSlikaZaOpisAktivnosti.setImageResource(R.drawable.timer_niski_intenzitet);
                            textViewNatpisZaOpisAktivnosti.setText(getResources().getString(R.string.liiState));
                            String tekstHodaj = editTextLIIVrijeme.getText().toString();
                            long longHodaj = Long.parseLong(tekstHodaj);

                            CountDownTimer timerHodaj = new CountDownTimer(longHodaj * 1000 + 100, 1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    updateTimer((int) millisUntilFinished / 1000);
                                }

                                @Override
                                public void onFinish() {
                                    textViewGlavniTimer.setText("00:00");
                                    textViewNatpisZaOpisAktivnosti.setText(getResources().getString(R.string.hiiState));
                                    counterInt--;
                                    poslijeDelaya(counterInt);
                                }
                            }.start();

                        }
                    }.start();
                } else {
                    textViewNatpisZaOpisAktivnosti.setText("Done");
                }
            }
        });