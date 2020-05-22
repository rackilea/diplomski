private Deque<Channel> channels;
            protected void handleControlMessage(Map<String, Object> jsonObject) {
            logger.info("Control message : " + jsonObject);
            String controlType = (String) jsonObject.get("control_type");
            if ("CONNECTION_DRAINING".equals(controlType)) {
                connectionDraining = true;
            } 
        }