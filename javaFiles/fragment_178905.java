import android.telephony.TelephonyManager;
import android.content.Context;

TelephonyManager telephonyManager;
telephonyManager = (TelephonyManager) getSystemService(Context.
                TELEPHONY_SERVICE);
/*
 * getDeviceId() returns the unique device ID.
 * For example,the IMEI for GSM and the MEID or ESN for CDMA phones.
*/
String deviceId = telephonyManager.getDeviceId();