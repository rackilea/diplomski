/**
 * Identical to {@link #CONNECTIVITY_ACTION} broadcast, but sent without any
 * applicable {@link Settings.Secure#CONNECTIVITY_CHANGE_DELAY}.
 *
 * @hide
 */
@SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
public static final String CONNECTIVITY_ACTION_IMMEDIATE =
        "android.net.conn.CONNECTIVITY_CHANGE_IMMEDIATE";