package com.exception.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(method = RequestMethod.GET)
public class TestExceptionController {

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {

        System.out.println("in controller");

        model.put("message", "hello spring boot");

        return "welcome";
    }

}