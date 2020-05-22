package test;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test/**")
public class MyController {

    private static final Logger logger = Logger.getLogger(MyController.class);

    @RequestMapping(value = "/test/params", method = RequestMethod.GET)
    public void test(SearchRequestParams requestParams, BindingResult result) {
    logger.debug("fq = " + StringUtils.join(requestParams.getFq(), "|"));
    }
}