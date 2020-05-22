if (message instanceof ShortMessage) {
    ShortMessage shortMessage = (ShortMessage) message;

    if(shortMessage.getCommand() == ShortMessage.NOTE_ON) {
        int channel = shortMessage.getChannel();
        int pitch = shortMessage.getData1();
        int vel = shortMessage.getData2();
        if(vel > 0) {
            shortMessage.setMessage(ShortMessage.NOTE_ON, channel, pitch + pitchUpOrDown, vel);
        }
    }
}