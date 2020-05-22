try {
        BufferedReader br = new BufferedReader(new FileReader(file));

        List<LeaderBoardEntry> leaders = new ArrayList<>();

        String x;
        while ((x = br.readLine()) != null) {
            LeaderBoardEntry leaderBoardEntry = new LeaderBoardEntry();
            String[] splits = x.split(" - ");
            leaderBoardEntry.setName(splits[0]);
            leaderBoardEntry.setScore(Integer.parseInt(splits[1]));
            leaders.add(leaderBoardEntry);
        }


        Collections.sort(leaders);

        StringBuilder leaderBoardStr = new StringBuilder();

        for (LeaderBoardEntry leaderBoardEntry : leaders) {
            leaderBoardStr.append(leaderBoardEntry.getName())
                    .append(" - ")
                    .append(leaderBoardEntry.getScore())
                    .append("\n");
        }

        String s = tLB.getText();
        tLB.setText( s + "\n" + leaderBoardStr.toString());

    } catch (Exception E) {
        System.out.println("cant read leaderboard");
    }