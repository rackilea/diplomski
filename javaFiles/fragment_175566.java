package temp;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    private static final Logger logger = Logger.getLogger(TestController.class);

    @RequestMapping("/")
    public @ResponseBody
    String home(HttpServletRequest req) {
        Device device = DeviceUtils.getCurrentDevice(req);
        String msg = "";
        if (device.isMobile()) {
            msg = "Hello mobile user!";
        } else {
            msg = "Hello desktop user!";
        }
        logger.info(msg);
        return msg;
    }
}