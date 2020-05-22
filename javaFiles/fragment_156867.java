if (response.isSuccessful()) {
                    // Got a successful response (Code 200...300)

                    MainCard mainCard = response.body();

                    if (mainCard != null && mainCard.cards != null) {
                        List<Item> recentlyUpdates = mainCard.cards.recentlyUpdates;
                        List<Item> newlyArrives = mainCard.cards.newlyArrives;

                        // ***** Use your information to set up the recyclerview. ***** 
                        // I am going to set up only the recentlyUpdates list.
                        setupRecyclerView(recentlyUpdates);
                    }
                }