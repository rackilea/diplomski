for (ObjectName destination: destinations) {
    if (destination.getKeyProperty("Name").equalsIgnoreCase(selectedQueue)) {
        try {
            String cursor = (String)mbeanServerConnection.invoke(destination, "getMessages", new Object[] {"", 0}, new String[] {"java.lang.String", "java.lang.Integer"});
            Long cursorSize = (Long)mbeanServerConnection.invoke(destination, "getCursorSize", new Object[] {cursor}, new String[] {"java.lang.String"});
            //System.out.println(cursor + ": " + cursorSize);
            CompositeData[] messages = (CompositeData[])mbeanServerConnection.invoke(destination, "getNext", new Object[] {cursor, cursorSize.intValue()}, new String[] {"java.lang.String", "java.lang.Integer"});
            if (null != messages) {
                for (CompositeData message: messages) {
                    JMSMessageInfo messageInfo = new JMSMessageInfo(message);
                    Long messageInfoHandle = messageInfo.getHandle();
                    CompositeData messageCursor = (CompositeData)mbeanServerConnection.invoke(destination, "getMessage", new Object[] {cursor, messageInfoHandle}, new String[] {"java.lang.String", "java.lang.Long"});
                    JMSMessageInfo mbi = new JMSMessageInfo(messageCursor);
                    WLMessage messageBody = mbi.getMessage();
                    body = messageBody.toString().substring(messageBody.toString().indexOf(", ") + 2, messageBody.toString().length()-1);
                    Object[] row = {counter, body};
                    publish(row);
                    if (isCancelled()) {
                        modelMessages.setRowCount(0);
                        return model;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            modelMessages.setRowCount(0);
            return model;
        }
    }
}