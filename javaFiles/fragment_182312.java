package com.an.csv.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/myclass")
public class TestControllerEx {

 @GetMapping
  public ResponseEntity control(){
    return new ResponseEntity("success",HttpStatus.OK);
  }
}