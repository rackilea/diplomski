sineOsc1.setEnabled( false ); // begin disabled
sineOsc2.setEnabled( false );
lineOut.start();

sineOsc1.setEnabled(true); // start left
sleep(1000);
sineOsc2.setEnabled(true); // after 1s, start right
sleep(1000);
sineOsc1.setEnabled( false ); // after 1s, stop left
sleep(1000);
sineOsc2.setEnabled( false ); // after 1s, stop