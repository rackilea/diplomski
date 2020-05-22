public class Tournament {

    private List<TournamentDay> days;

    public Tournament() {
        this.days = new ArrayList<TournamentDay>();
    }

    public void add(TournamentDay day) {
        days.add(day);
    }
}

public class TournamentDay {

    private List<Match> matches;

    public TournamentDay() {
        this.matches = new ArrayList<Match>();
    }

    public void add(Match match) {
        matches.add(match);
    }
}