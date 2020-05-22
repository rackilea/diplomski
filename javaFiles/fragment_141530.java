case R.id.play_button:
        if(isPlayingInstrument == false) {
            if(player == null)
                initializePlayer();

            if(player != null) {
                isPlayingInstrument = true;
                player.start();
                myChronometer.setBase(SystemClock.elapsedRealtime());
            }
        }
    break;

    case R.id.pause_button:
        if(player != null) {
            player.pause();
            isPlayingInstrument = false;
        }
        break;

    case R.id.stop_button:
        if(player != null) {
            player.stop();
            player = null;
            isPlayingInstrument = false;
            play_thread_running = false;
        }
        break;