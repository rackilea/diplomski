package com.mydemo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = "/index")
    public String main(){
        return "index";
    }

    @RequestMapping(value = "/private")
    public String getPrivate(){
        return "private";
    }
}