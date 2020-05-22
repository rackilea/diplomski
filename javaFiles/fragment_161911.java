Observable<Match> matches = leagues.flatMap(
    new Func1<League, Observable<Match>> () {
        @Override
        public Observable<Match> call(League league) {
            return getMatchesPlayed(league.leagueId, true);
        }
    });