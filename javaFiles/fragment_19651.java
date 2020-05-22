interface Changeable <T extends Number> {
            void setChannel(T channelNumber) throws wrongStation;
            T getChannel();
            T getMinChannel();
            T getMaxChannel();
            T getChannelIncrement();
        }