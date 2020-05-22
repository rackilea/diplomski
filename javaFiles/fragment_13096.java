while(true) {
        String topic = br.readLine();
        if(topic == null)
            break;
        chatBox.put(topic, new ArrayList<String>());
    }