@Service
public class PasswordResetRequestService {

@Value("${hours.expired:12}") 
private int hoursExpiredPassword;

@Autowired
private PasswordResetRequestDao passwordResetRequestDao;

public void setHoursExpiredPassword(int hoursExpiredPassword) {
    this.hoursExpiredPassword = hoursExpiredPassword;
}


@Override
public ERequests checkRequest(String number, Date date) {
    PasswordResetRequest findedObject = passwordResetRequestDao.getObjectByElement(PasswordResetRequest.class, "requestId", number);
    if (findedObject == null){
        return ERequests.BAD_REQUEST;
    }else{
        long result = getDateDiff(findedObject.getRequestDate(),date,TimeUnit.HOURS);
        if(result >= hoursExpiredPassword){
            return ERequests.EXPIRED_REQUEST;
        }
    }
    return ERequests.CORRECT_REQUEST;
   }

}