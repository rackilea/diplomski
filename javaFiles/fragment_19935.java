Class pcscterminal = Class.forName("sun.security.smartcardio.PCSCTerminals");
        Field contextId = pcscterminal.getDeclaredField("contextId");
        contextId.setAccessible(true);

        if(contextId.getLong(pcscterminal) != 0L)
        {
            // First get a new context value
            Class pcsc = Class.forName("sun.security.smartcardio.PCSC");
            Method SCardEstablishContext = pcsc.getDeclaredMethod(
                                               "SCardEstablishContext",
                                               new Class[] {Integer.TYPE }
                                           );
            SCardEstablishContext.setAccessible(true);

            Field SCARD_SCOPE_USER = pcsc.getDeclaredField("SCARD_SCOPE_USER");
            SCARD_SCOPE_USER.setAccessible(true);

            long newId = ((Long)SCardEstablishContext.invoke(pcsc, 
                    new Object[] { SCARD_SCOPE_USER.getInt(pcsc) }
            ));
            contextId.setLong(pcscterminal, newId);


            // Then clear the terminals in cache
            TerminalFactory factory = TerminalFactory.getDefault();
            CardTerminals terminals = factory.terminals();
            Field fieldTerminals = pcscterminal.getDeclaredField("terminals");
            fieldTerminals.setAccessible(true);
            Class classMap = Class.forName("java.util.Map");
            Method clearMap = classMap.getDeclaredMethod("clear");

            clearMap.invoke(fieldTerminals.get(terminals));
        }