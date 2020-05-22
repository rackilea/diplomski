Map<Integer, Integer> map = bids.stream().collect(
        groupingBy(
                Bid::getBidderUserId,
                collectingAndThen(
                        mapping(Bid::getAuctionId, toSet()),
                        Set::size)));