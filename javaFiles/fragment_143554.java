package com.example.demo.controller;

import com.example.demo.model.Meet;
import com.example.demo.service.MeetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/book"})
public class MeetController {

    @Autowired
    MeetServiceImpl bookService;

    @RequestMapping("")
    public String home(){
        return "Hello World!";
    }

    @GetMapping(path = {"/{id}"})
    public Meet getBook(@PathVariable("id") int id) {
        return null;
    }

    @PostMapping("/create/{name}/author/{id}")
    public ResponseEntity<Meet> createBook() {
        return null;
    }
}