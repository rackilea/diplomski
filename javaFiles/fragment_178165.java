@Reference
CommandProcessor commandProcessor;

...

CommandSession commandSession = commandProcessor.createSession(System.in, System.out, System.err);
commandSession.execute("..");