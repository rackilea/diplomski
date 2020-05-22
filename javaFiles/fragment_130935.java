package com.example.editor.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.editor.Configuration;


  @Autowired
  Configuration confg;

    @Controller
    @RequestMapping("/")
    public class EditorController {

        private static final String start = "Editor";

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String start(ModelMap model) throws IOException{

        model.addAttribute("URL", confg.getHostURL());

            return start;
        }

    }
    public void setHostURL(String url){
        this.hostURL = url;
        System.out.println("URL:"+this.hostURL);
    }

}