interface Changeable {
            void setChannel(Number channelNumber) throws wrongStation;
            Number  getChannel();
            Number getMinChannel();
            Number getMaxChannel();
            Number getChannelIncrement();
        }