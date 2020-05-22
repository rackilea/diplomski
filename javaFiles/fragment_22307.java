package com.foo;

import com.foo.event.UserSettings;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

import javax.portlet.Event;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.portlet.bind.annotation.EventMapping;

@Controller
@RequestMapping("VIEW")
public class ViewHistory {
    private UserSettings userSettings = new UserSettings();

    @ModelAttribute("userSettings")
    public UserSettings createUserSettings(Model model) {
        return userSettings;
    }

    @RequestMapping
    public String doSearch(Model model) {
        return "view";
    }

    @ActionMapping(params = "action=search")
    public void searchAction(
            Model model,
            ActionRequest request, ActionResponse response,
            @ModelAttribute("userSettings") UserSettings userSettings,
            BindingResult bindingResult, SessionStatus status)
    {
        // do something
    }

    /**
     * Spring calls this whenever an event is received.
     * Can be limited to certain event.
     */
    @EventMapping
    public void handleEvent(EventRequest request) {
        Event event = request.getEvent();

        if (event.getName().equals("UserSettings")) {
            userSettings = (UserSettings)event.getValue();
        }
    }
}