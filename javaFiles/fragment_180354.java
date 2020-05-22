package com.test.util;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;

@Plugin(name = "shiro", category = "Converter")
@ConverterKeys({"susr", "shiro"})
public class ShiroUserConverter extends LogEventPatternConverter {

private static final ShiroUserConverter INSTANCE = new ShiroUserConverter();

private ShiroUserConverter()
{
    this("shiro", "shiro"); // not sure why!
}

protected ShiroUserConverter(String name, String style) {
    super(name, style);
}

public static ShiroUserConverter newInstance(final String[] options) {
    return INSTANCE;
}

@Override
public void format(LogEvent arg0, StringBuilder arg1) {
    // TODO Auto-generated method stub
        arg1.append("No User");
}