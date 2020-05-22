public static final int DO_ACTION_1 = 0;
public static final int DO_ACTION_5 = 4;

    @Override
    public void onDone(final String utteranceId) {

            switch (Integer.valueOf(utteranceId)) {

                case DO_ACTION_1:
                    // do something
                    break;
                case DO_ACTION_5:
                    // do something else
                    break;
                default:
                    // do nothing
                    break;
            }
    }