Arrays.sort(listOfWinners, new Comparator<Winner>() {

            @Override
            public int compare(Winner o1, Winner o2) {

                return o1.team.compareTo(o2.team);
            }
        });