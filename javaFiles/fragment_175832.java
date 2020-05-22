package com.raf.test.pages;

import java.util.Date;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

public class Names {
    @Inject
    private Logger logger;

    @Property
    @Persist(PersistenceConstants.FLASH)
    private String birthDay;

    @Property
    @Persist(PersistenceConstants.FLASH)
    private String birthMonth;

    @Property
    @Persist(PersistenceConstants.FLASH)
    private String birthYear;

    @Property
    @Persist(PersistenceConstants.FLASH)
    private String aDate;

    @Property
    @Persist(PersistenceConstants.FLASH)
    private String monthAndYear;

    @Property
    @Persist(PersistenceConstants.FLASH)
    private Date actualDateField;

    Object onSuccess() {
       logger.info("birthDay: " + birthDay);
       logger.info("birthMonth: " + birthMonth);
       logger.info("birthYear: " + birthYear);

       if(aDate != null && !aDate.isEmpty()) {
           String[] chunks = aDate.split("-");
           if(chunks.length > 2) {
               logger.info("aDate [Year]: " + chunks[0]);
               logger.info("aDate [Month]: " + chunks[1]);
               logger.info("aDate [Day]: " + chunks[2]);
           }
       }

       logger.info("monthAndYear: " + monthAndYear);

       logger.info("actualDateField: " + actualDateField);

       return null;
    }
}