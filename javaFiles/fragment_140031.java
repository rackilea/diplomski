public class ContestantComparator implements Comparator<Contestant> {

    @Override
    public int compare(Contestant one, Contestant two) {
        int contestantOneSwimTime = one.getTimingFor("Swimming");
        int contestantTwoSwimTime = two.getTimingFor("Swimming");

        if(contestantOneSwimTime<contestantTwoSwimTime) {
            return -1;
        } else if(contestantOneSwimTime>contestantTwoSwimTime) {
            return 1;
        } else {
            int c1RemainingTimeExceptSwimming = 0;
            int c2RemainingTimeExceptSwimming = 0;

            for(String activity : one.getTimings().keySet()) {
                if(!activity.equals("Swimming")) {
                    c1RemainingTimeExceptSwimming+=one.getTimingFor(activity);
                }
            }

            for(String activity : two.getTimings().keySet()) {
                if(!activity.equals("Swimming")) {
                    c2RemainingTimeExceptSwimming+=two.getTimingFor(activity);
                }
            }

            if(c1RemainingTimeExceptSwimming>c2RemainingTimeExceptSwimming) {
                return -1;
            } else if(c1RemainingTimeExceptSwimming<c2RemainingTimeExceptSwimming) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}