package com.stackoverflow.sample.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/whatever")
public class SampleController {

    @Autowired
    private NotificationMessagingTemplateCustom template;

    @RequestMapping(method = RequestMethod.GET)
        public String handleGet() {
            this.template.sendNotification("message", "subject");
            return "yay";
        }
    }
}