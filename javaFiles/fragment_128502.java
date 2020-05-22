package org.sandbox.log4j;

import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.RollingFileAppender;
import org.apache.logging.log4j.core.appender.rolling.RollingFileManager;
import org.apache.logging.log4j.core.appender.rolling.RolloverDescription;
import org.apache.logging.log4j.core.appender.rolling.RolloverStrategy;
import org.apache.logging.log4j.core.layout.ByteBufferDestination;

import java.util.Map;

public class RollingAppenderNew {
    public static void main(String[] args) {
        Layout<String> myLayout = new Layout<String>() {
            @Override
            public byte[] getFooter() {
                return new byte[0];
            }

            @Override
            public byte[] getHeader() {
                return new byte[0];
            }

            @Override
            public byte[] toByteArray(LogEvent event) {
                return new byte[0];
            }

            @Override
            public String toSerializable(LogEvent event) {
                return null;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public Map<String, String> getContentFormat() {
                return null;
            }

            @Override
            public void encode(LogEvent source, ByteBufferDestination destination) {

            }
        };

        RolloverStrategy myStrategy = new RolloverStrategy() {
            @Override
            public RolloverDescription rollover(RollingFileManager manager) throws SecurityException {
            return null;
            }
        };

        RollingFileAppender appender = RollingFileAppender.newBuilder()
            .withName("MyAppender")
            .withLayout(myLayout)
            .withStrategy(myStrategy)
            .build();
    }
}