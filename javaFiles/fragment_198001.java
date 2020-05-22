import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.tuple.Pair;

public class roundTeams {

    public static HashMap<Integer, ArrayList<Pair<String, String>>> buildRounds(int numberOfTeams) {

        if (numberOfTeams % 2 != 0  ) {
            throw new IllegalArgumentException("An even number of teams is required");
        }

        HashMap<Integer, ArrayList<Pair<String, String>>> roundTeams = new HashMap<Integer, ArrayList<Pair<String, String>>>();

        // Build first round
        ArrayList<Pair<String, String>> round = new ArrayList<Pair<String, String>>();
        for (int i=1; i<=numberOfTeams; ) {
            Pair<String, String> pair = Pair.of(""+i++, ""+i++);
            round.add(pair);
        }
        roundTeams.put(0,round);

        // Build other rounds
        int numberOfRounds = (numberOfTeams - 1);
        for (int i=1; i<numberOfRounds; i++) {
            roundTeams.put(i, transformRound(roundTeams, i));
        }

        return roundTeams;
    }

    /**
     * Create a new round based on existing rounds.
     * @param roundTeams  an array list of rounds. It must have at least one "seed" round.
     * @param i  The zero-based index of the round to add.
     * @return the new round.
     */
    @SuppressWarnings("unchecked")
    private static ArrayList<Pair<String, String>> transformRound(
            HashMap<Integer, ArrayList<Pair<String, String>>> roundTeams,
            int i) {

        if (roundTeams.isEmpty())
            throw new IllegalArgumentException("roundTeams is empty. It must have at least one seed round.");

        ArrayList<Pair<String, String>> round = new ArrayList<Pair<String, String>>();

        if (i>1) {
            // Clone is important here as we will be changing the round values to
            // create a new round and don't want to change the old values.
            round = (ArrayList<Pair<String, String>>) roundTeams.get(i-2).clone(); 

            // Transform/rotate the elements in pairs 2 on
            for (int j=1; j < round.size(); j++) {
                Pair<String, String> pair = round.get(j);
                String key = pair.getKey();
                String value = pair.getValue();
                pair = Pair.of(value, key);
                round.set(j, pair);
            }
        }
        else {
            // Since there is no "zero" round, the second round is based on the 
            // first/seed round without the transform.
            round = (ArrayList<Pair<String, String>>) roundTeams.get(0).clone();
        }

        // Swap right-left elements in neighboring pairs
        for (int j=1; j < round.size(); j++) {
            Pair<String, String> pair = round.get(j-1);
            String key1 = pair.getKey();
            String value1 = pair.getValue();
            pair = round.get(j);
            String key2 = pair.getKey();
            String value2 = pair.getValue();
            pair = Pair.of(key1, key2);
            round.set(j-1, pair);
            pair = Pair.of(value1, value2);
            round.set(j, pair);
        }
        return round;
    }

    final static int NUM_TEAMS = 20;

    public static void main(String[] args) {

        HashMap<Integer, ArrayList<Pair<String, String>>> rounds = buildRounds(NUM_TEAMS);

        for (int i = 0; i < rounds.size(); i++) {
            System.out.println(i+1 + ": " + rounds.get(i));
        }
    }
}