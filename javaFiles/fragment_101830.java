enum PokerHand {
    STRAIGHT {
        @Override
        boolean matches(List<Card> hand) {

            for (int i = 1; i < hand.size(); i++) {
                if (
                    card.get(i).getRank() !=
                    card.get(i - 1).getRank() + 1
                ) {
                    return false;
                }
            }

            return true;
        }
    },
    FOUR_OF_A_KIND {
        @Override
        boolean matches(List<Card> hand) {

            int[] rankCount = new int[14];

            /* count up the ranks in the hand */
            for (Card card : hand) {
                rankCount[card.getRank()]++;
            }

            boolean foundHasOne = false;
            boolean foundHasFour = false;

            /* now evaluate exclusively
             * there must be only a 1 count and a 4 count
             */
            for (int i = 1; i < rankCount.length; i++) {

                if (rankCount[i] == 1) {
                    if (!foundHasOne) {
                        foundHasOne = true;
                    } else {
                        return false;
                    }

                } else if (rankCount[i] == 4) {
                    if (!foundHasFour) {
                        foundHasFour = true;
                    } else {
                        return false;
                    }

                } else if (rankCount[i] != 0) {
                    return false;
                }
            }

            return true;
        }
    },
    ROYAL_FLUSH {
        final int[] rfRanks = {
            1, 10, 11, 12, 13
        };

        @Override
        boolean matches(List<Card> hand) {

            for (int i = 0; i < rfRanks.length; i++) {
                if (rfRanks[i] != hand.get(i).getRank())
                    return false;
            }

            return true;
        }
    };

    abstract boolean matches(List<Card> hand);
}