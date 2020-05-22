.subscribe(response -> {
        ArrayList<UpcomingGuest> upcomingGuests = new ArrayList<>();

        //sort meetings by date
        List<UpcomingGuestsList.Meeting> meetings = response.meetings;
        Collections.sort(meetings, new Comparator<UpcomingGuestsList.Meeting>() {
            @Override
            public int compare(UpcomingGuestsList.Meeting meeting, UpcomingGuestsList.Meeting t1) {
                return meeting.getDateStart().compareTo(t1.getDateStart());
            }
        });

        for (UpcomingGuestsList.Meeting meeting: meetings) {
            //sort visitors by last name
            List<UpcomingGuestsList.Visitor> visitors = meeting.visitors;
            Collections.sort(visitors, new Comparator<UpcomingGuestsList.Visitor>() {
                @Override
                public int compare(UpcomingGuestsList.Visitor visitor, UpcomingGuestsList.Visitor t1) {
                    return visitor.getLastName().compareTo(t1.getLastName());
                }
            });

            for(UpcomingGuestsList.Visitor visitor: visitors){

                upcomingGuests.add(new UpcomingGuest(visitor,meeting));
            }
        }

        // send upcomingGuests results to view


}