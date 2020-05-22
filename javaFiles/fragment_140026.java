.subscribe(response -> {
                    int sizercount = 0;
                    for (UpcomingGuestsList.Meeting meeting: response.meetings) {
                        for(UpcomingGuestsList.Visitor visitor: meeting.visitors){
                            upcomingGuests.add(new UpcomingGuest(visitor,meeting));
                        }
                    }

                    // send upcomingGuests results to view


                }