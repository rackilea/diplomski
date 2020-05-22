import com.android.internal.telephony.PhoneFactory;
import com.android.internal.telephony.PhoneBase;

PhoneBase phone = (PhoneBase)PhoneFactory.getDefaultPhone();//or PhoneFactory.getPhone(SIM_ID);
//RIL_REQUEST_GET_SIM_STATUS    
phone.mCi.getIccCardStatus(result);
//RIL_REQUEST_DIAL
phone.mCi.dial (address, clirMode, result);
//RIL_REQUEST_SEND_SMS
phone.mCi.sendSMS (smscPDU, pdu, result);