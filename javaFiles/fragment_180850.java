package org.myorg.myapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

  @RequestMapping(value = "/form", method = RequestMethod.GET)
  public ModelAndView showForm() {
    ModelAndView mav = new ModelAndView("form");
    List<IdAndName> options = Arrays.asList(
        new IdAndName("id1", "name1"),
        new IdAndName("id2", "name2"),
        new IdAndName("id3", "name3")
    );
    mav.addObject("options", options);

    MyForm myForm = new MyForm();
    myForm.setValueOfSelectElement("default-value");
    mav.addObject("myForm", myForm);

    return mav;
  }

  @RequestMapping(value = "/form", method = RequestMethod.POST)
  @ResponseBody
  public String processForm(MyForm myForm) {
    return myForm.getValueOfSelectElement();
  }

  static class MyForm {
    private String valueOfSelectElement;

    public String getValueOfSelectElement() {
      return valueOfSelectElement;
    }

    public void setValueOfSelectElement(String valueOfSelectElement) {
      this.valueOfSelectElement = valueOfSelectElement;
    }
  }

  static class IdAndName {
    private String id;

    private String name;

    public IdAndName(String id, String name) {
      this.id = id;
      this.name = name;
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}