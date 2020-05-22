package com.gasx.corex.scheduler.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasx.corex.ext.scheduler.domain.SchedulerJob;
import com.gasx.corex.scheduler.rest.SchedulerJobRestRepositoryI;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SchedulerJobService implements SchedulerJobServiceI {

    @Autowired
    private SchedulerJobRestRepositoryI schedulerJobRestRepositoryI;

    @Override
    @Transactional
    public void addSchedulerJob(SchedulerJob schedulerJob) {
        SchedulerJobRestRepositoryI.save(schedulerJob);
    }

}