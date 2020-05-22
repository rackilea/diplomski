package com.gasx.corex.scheduler.controller;

import java.awt.*;
import java.util.List;

import com.gasx.corex.scheduler.service.SchedulerJobServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gasx.corex.ext.scheduler.domain.SchedulerJob;
import com.gasx.corex.scheduler.service.SchedulerJobService;


    @RestController
    @RequestMapping("/gasx/restscd")
    public class SchedulerJobController {

        @Autowired
        private SchedulerJobService schedulerJobService;



        @RequestMapping(method = RequestMethod.POST, value = "/addschedulerjob")
        public void addSchedulerJob(@RequestBody SchedulerJob schedulerJob) {
            schedulerJobService.addSchedulerJob(schedulerJob);
        }

    }