package com.fwd.pmap.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fwd.pmap.memberInterfaceFile.CsvReader;
import com.fwd.pmap.memberInterfaceFile.CsvWriter;;

@Component
public class MyBean {

    @Scheduled(cron="0 0 5 * * *")
    public void importInterfaceFile()
    {
        CsvReader reader = new CsvReader();
        try {
            reader.importInterfaceFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron="0 0 6 * * *")
    public void generateInterfaceFile()
    {
        CsvWriter writer = new CsvWriter();
        try {
            writer.generateInterfaceFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}