package com.demo.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.codehaus.jackson.map.annotate.JsonView;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@Controller
public class DemoController {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value="/jsonOutput")
    @ResponseBody
    public String myObject(HttpServletResponse response) throws IOException {
        ObjectWriter objectWriter = objectMapper.writerWithView(Views.Public.class);
        return objectWriter.writeValueAsString(new MyObject());
    }

    public static class Views {
        static class Public {}
        static class ExtendPublic extends Public {}
    }

    public class MyObject {
        @JsonView(Views.Public.class) Integer id = 1;
        @JsonView(Views.ExtendPublic.class) String name = "name";
    }
}