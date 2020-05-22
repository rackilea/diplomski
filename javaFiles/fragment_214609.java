if (message.getVersion() instanceof Soap11) {
            Map<String, List<String>> headers = CastUtils.cast((Map)message.get(Message.PROTOCOL_HEADERS));
            if (headers != null) {
                List<String> sa = headers.get("SOAPAction");
                if (sa != null && sa.size() > 0) {
                    String action = sa.get(0);
                    if (action.startsWith("\"")) {
                        action = action.substring(1, action.length() - 1);
                    }
                    if (StringUtils.equals(action, "YOUR_SPECIAL_ACTION" ) {
                        doYourSpecialProcessint(message, action);
                    }
                }
            }
        } else if (message.getVersion() instanceof Soap12) {
          ...........
        }