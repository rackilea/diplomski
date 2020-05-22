Promise<Meeting> meetingPromise = new Job<Meeting> () {         
    @Override
    public Meeting doJobWithResult() throws Exception {
        Meeting meeting = Meeting.findById(id);
        while (meeting.bbbMeetingId == null) {
            Thread.sleep(1000);
            if (JPA.isInsideTransaction()) {
                JPAPlugin.closeTx(false);
            }
            JPAPlugin.startTx(true);
            meeting = Meeting.findById(id);
            JPAPlugin.closeTx(false);
        }
        return meeting;
    }
}.now();
Meeting meeting = await(meetingPromise);