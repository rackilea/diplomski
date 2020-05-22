public void log(String message, Integer level) {
        Match(level).of(
                Case($(INFO), l -> run( () -> logger.info(message))), //
                Case($(DEBUG), l -> run( () -> logger.debug(message))), //
                Case($(WARNING), l -> run( () -> logger.warn(message))), //
                Case($(ERROR), l -> run( () -> logger.error(message))), //
                Case($(), l -> run( () -> logger.info(message)))); 
}