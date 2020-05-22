package com.yt.nss.rest.query.mock.controller;


import org.springframework.http.HttpStatus;
import ....

@Controller
@RequestMapping("/eaapps")
public class EAApplicationsController {


@RequestMapping(method = RequestMethod.POST)
public ResponseEntity<Object> submitMessage(final @RequestBody EAApplication eaApplication) {

    System.out.println(eaApplication);
    return new ResponseEntity<Object>(null, HttpStatus.OK);
}