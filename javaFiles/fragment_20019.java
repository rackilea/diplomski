BidEventDataStream.keyBy(new KeySelector<BidEvent, Long>() {
                    @Override
                    public Long getKey(BidEventvalue) {
                        return value.getBidId();
                    }
                })