package com.example.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;

public class LogbackTest
{
    private static class ModifyingFilter
    extends TurboFilter
    {
        @Override
        public FilterReply decide(
                Marker marker,
                ch.qos.logback.classic.Logger logger, 
                Level level,
                String format, 
                Object[] params, 
                Throwable t)
        {
            if (level == Level.ERROR &&
                logger.getName().equals("com.example.logback.LogbackTest") &&
                format.equals("Connection successful: {}"))
            {
                logger.debug(marker, format, params);
                return FilterReply.DENY;
            }

            return FilterReply.NEUTRAL;
        }
    }

    public static void main(String[] args)
    {
        LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();
        lc.addTurboFilter(new ModifyingFilter());

        Logger logger = LoggerFactory.getLogger(LogbackTest.class);
        logger.error("Connection successful: {}", "no problem", new RuntimeException("Hi"));
    }
}