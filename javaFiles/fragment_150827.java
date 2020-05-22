/**
     * Our {@link AudioManager.OnAudioFocusChangeListener}
     */
    private static AudioManager.OnAudioFocusChangeListener audioFocus = new AudioManager.OnAudioFocusChangeListener() {

        @Override
        public void onAudioFocusChange(final int focusChange) {
            if (DEBUG) {
                MyLog.i(CLS_NAME, "AudioManager focusChange: " + focusChange);
            }

            switch (focusChange) {

                case AudioManager.AUDIOFOCUS_GAIN:
                    if (DEBUG) {
                        MyLog.i(CLS_NAME, "AudioManager focusChange: AUDIOFOCUS_GAIN");
                    }
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    if (DEBUG) {
                        MyLog.i(CLS_NAME, "AudioManager focusChange: AUDIOFOCUS_LOSS");
                    }
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                    if (DEBUG) {
                        MyLog.i(CLS_NAME, "AudioManager focusChange: AUDIOFOCUS_LOSS_TRANSIENT");
                    }
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    if (DEBUG) {
                        MyLog.i(CLS_NAME, "AudioManager focusChange: AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                    }
                    break;
                default:
                    if (DEBUG) {
                        MyLog.i(CLS_NAME, "AudioManager focusChange: AUDIOFOCUS default");
                    }
                    break;
            }
        }
    };

    /**
     * Duck the audio
     *
     * @param ctx the application context
     */
    public static void duckAudioMedia(final Context ctx) {
        if (DEBUG) {
            MyLog.i(CLS_NAME, "duckAudioMedia");
        }

        try {

            final AudioManager audioManager = (AudioManager) ctx.getSystemService(Context.AUDIO_SERVICE);

            switch (audioManager.requestAudioFocus(audioFocus, AudioManager.STREAM_MUSIC,
                    AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK)) {

                case AudioManager.AUDIOFOCUS_REQUEST_FAILED:
                    if (DEBUG) {
                        MyLog.w(CLS_NAME, "AudioManager duckAudioMedia AUDIOFOCUS_REQUEST_FAILED");
                    }
                    break;
                case AudioManager.AUDIOFOCUS_REQUEST_GRANTED:
                    if (DEBUG) {
                        MyLog.i(CLS_NAME, "AudioManager duckAudioMedia AUDIOFOCUS_REQUEST_GRANTED");
                    }
                    break;
                default:
                    if (DEBUG) {
                        MyLog.i(CLS_NAME, "AudioManager duckAudioMedia AUDIOFOCUS default");
                    }
                    break;
            }
        } catch (final NullPointerException e) {
            if (DEBUG) {
                MyLog.w(CLS_NAME, "duckAudioMedia: NullPointerException");
                e.printStackTrace();
            }
        } catch (final Exception e) {
            if (DEBUG) {
                MyLog.w(CLS_NAME, "duckAudioMedia: Exception");
                e.printStackTrace();
            }
        }
    }

   /**
     * Notify the System that any previous condition requiring to duck or pause audio is now complete.
     *
     * @param ctx the application context
     */
    public static void abandonAudioMedia(final Context ctx) {
        if (DEBUG) {
            MyLog.i(CLS_NAME, "abandonAudioMedia");
        }

        try {

            final AudioManager audioManager = (AudioManager) ctx.getSystemService(Context.AUDIO_SERVICE);

            switch (audioManager.abandonAudioFocus(audioFocus)) {

                case AudioManager.AUDIOFOCUS_REQUEST_FAILED:
                    if (DEBUG) {
                        MyLog.w(CLS_NAME, "AudioManager abandonAudioMedia AUDIOFOCUS_REQUEST_FAILED");
                    }
                    break;
                case AudioManager.AUDIOFOCUS_REQUEST_GRANTED:
                    if (DEBUG) {
                        MyLog.i(CLS_NAME, "AudioManager abandonAudioMedia AUDIOFOCUS_REQUEST_GRANTED");
                    }
                    break;
                default:
                    if (DEBUG) {
                        MyLog.i(CLS_NAME, "AudioManager abandonAudioMedia AUDIOFOCUS default");
                    }
                    break;
            }
        } catch (final NullPointerException e) {
            if (DEBUG) {
                MyLog.w(CLS_NAME, "abandonAudioMedia: NullPointerException");
                e.printStackTrace();
            }
        } catch (final Exception e) {
            if (DEBUG) {
                MyLog.w(CLS_NAME, "abandonAudioMedia: Exception");
                e.printStackTrace();
            }
        }
    }