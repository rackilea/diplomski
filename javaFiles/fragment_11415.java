package com.infotel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotel.dto.OrganismeDTO;
import com.infotel.service.OrganismeService;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
@RequestMapping("/api/infotel")
public class Controller {

private final OrganismeService orgService;

public Controller(OrganismeService orgService) {
    this.orgService=orgService;
}

@PostMapping("/createOrganisme")
public ResponseEntity<?> create(@RequestBody OrganismeDTO org){
    System.out.println(org.toString());
    this.orgService.create(org);
    HttpHeaders headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin", "*");
    headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
    headers.add("Access-Control-Allow-Headers", "X-Requested-With,content-type");
    headers.add("Access-Control-Allow-Credentials", "true");
    return new ResponseEntity<>(headers,HttpStatus.CREATED);
}

@GetMapping("/getAllOrganismes")
public ResponseEntity<?> getAll(){
    List<OrganismeDTO> orgs = this.orgService.getAll();
    for(OrganismeDTO o : orgs) {
        System.out.println(o.toString());
    }
    HttpHeaders headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin", "*");
    headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
    return new ResponseEntity<>(orgs,headers, HttpStatus.OK);
}

}