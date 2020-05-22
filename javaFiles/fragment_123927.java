package com.bondarenko.tmp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class TestRouting {

private final static Logger log = LogManager.getLogger(TestRouting.class);

public static void main(String[] args) {
    ThreadContext.put("logFileName", "David");
    log.info("Error happened");

    ThreadContext.put("logFileName", "Mark");
    log.info("Something is broken");

    ThreadContext.remove("logFileName");
}
}