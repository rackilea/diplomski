package com.foo;

import com.foo.event.UserSettings;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

import javax.xml.namespace.QName;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("VIEW")
public class ViewSettings {
    private QName qname = new QName("http:foo.com/usersettings", "UserSettings");

    @ModelAttribute
    public UserSettings createUserSettings(Model model) {
        return new UserSettings();
    }

    @ActionMapping(params = "action=search")
    public void searchAction(
            Model model,
            ActionRequest request, ActionResponse response,
            @ModelAttribute("userSettings") UserSettings userSettings,
            BindingResult bindingResult, SessionStatus status)
    {
        // as soon as an action is triggered (save button is pressed or 
        // whatever), send the modified UserSettings instance as an 
        // event to the search portlet (actually any portlet, but I 
        // only have one that will read events).
        response.setEvent(qname, userSettings);
    }

    @RequestMapping
    public String doView(Model model) {
        return "view";
    }
}