package com.spring.batch.main;

import java.util.List;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.batch.domain.UserItemWriter;

public class Main {
    public static void main(String[] args) throws BeansException,
            JobExecutionAlreadyRunningException, JobRestartException,
            JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                "config/application-context.xml");
        JobLauncher jobLauncher = (JobLauncher) appContext.getBean("jobLauncher");
        jobLauncher.run(
                (Job) appContext.getBean("job"),
                new JobParametersBuilder().addString("input.file.name",
                        "file:src/main/resources/data/input.csv").toJobParameters());

        Map<String,List<String>> userMap=UserItemWriter.getUserMap();
        for (String userId : userMap.keySet()) {
            System.out.println(userId + ":" + userMap.get(userId));
        }
    }
}