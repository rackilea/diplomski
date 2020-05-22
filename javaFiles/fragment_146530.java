package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Controller
    public class DownloadController {

        @RequestMapping("/download")
        public ResponseEntity<InputStreamResource> download() throws FileNotFoundException {
            final File file = new File("file.pdf");
            return ResponseEntity.ok()
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_PDF)
                    .cacheControl(CacheControl.noCache())
                    .header("Content-Disposition", "attachment; filename=" + file.getName())
                    .body(new InputStreamResource(new FileInputStream(file)));
        }
    }
}