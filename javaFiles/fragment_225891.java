package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class Test {
public static void ThreadContextLoggerCreation(long param1, String param2, String param3) {
        ThreadContext.push(UUID.randomUUID().toString()); // Add the fishtag;
        ThreadContext.put("param1", param1);
        ThreadContext.put("param2", param2);
        ThreadContext.put("param3", param3);
        ThreadContext.pop();
    }

    public static void ThreadContextLoggerClear() {
        ThreadContext.clearAll();
    }
public static void main(String args[]) {
 Logger logger =  LogManager.getLogger(Test.class);   LogUtil.ThreadContextLoggerCreation(logger,currentTime,customerId,agentLocation,streamId,streamVariant,levelOfDetail);
            logger.info("Current Time of execution(HHmm) is: {}",BatchTimeUtil.convertTimestampToReadableDate(currentTime));
}
}