Map<Integer, Integer> map = bids.stream().collect(
        groupingBy(
                Bid::getBidderUserId,
                collectingAndThen(
                        groupingBy(Bid::getAuctionId, counting()),
                        Map::size)));