Comparator<Team> pointComparator = new Comparator<Team>() {
        @Override
        public int compare(Team o1, Team o2) {
            return o1.getPoints() - o2.getPoints();
        }
   };
   Collections.sort(teamsForDivision, pointComparator.reversed());