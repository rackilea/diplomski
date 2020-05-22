AppenderComponentBuilder consoleAppenderBuilder = builder
    .newAppender("Stdout", "CONSOLE")
    .addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);

RootLoggerComponentBuilder rootLoggerBuilder = builder
    .newRootLogger(Level.ALL)
    .add(builder.newAppenderRef("Stdout").addAttribute("level", Level.INFO));