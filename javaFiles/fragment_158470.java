import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.sarvika.commonslib.util.StringUtil;
import com.j256.totp.TwoFactorAuthUtil;

public class Authy2FactorThreadBean extends Thread implements ApplicationContextAware {

    private static final Logger logger = Logger.getLogger(Authy2FactorThreadBean.class);

    private String base32Secret;
    private String keyId;

    private String qrCodeImageUrl;
    private String code;

    @Override
    public void run() {
        try {
            TwoFactorAuthUtil twoFactorAuthUtil = new TwoFactorAuthUtil();

            qrCodeImageUrl = twoFactorAuthUtil.qrImageUrl(keyId, base32Secret);
            code = twoFactorAuthUtil.generateCurrentNumber(base32Secret);

            while (true) {
                code = twoFactorAuthUtil.generateCurrentNumber(base32Secret);
                Thread.sleep(1000);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext context)
            throws BeansException {

        if (StringUtil.isEmpty(base32Secret) || StringUtil.isEmpty(keyId)) {
            logger.warn("Base32 Secret or Key ID not provided. 2Factor Codes will not be generated!!!!!");
            return;
        }

        logger.info("Starting 2Factor Generation Thread...");
        start();

    }   

    public String getBase32Secret() {
        return base32Secret;
    }

    public void setBase32Secret(String base32Secret) {
        this.base32Secret = base32Secret;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getQrCodeImageUrl() {
        return qrCodeImageUrl;
    }

    public void setQrCodeImageUrl(String qrCodeImageUrl) {
        this.qrCodeImageUrl = qrCodeImageUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}