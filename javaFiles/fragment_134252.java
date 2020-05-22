public abstract class Person {
    public final String say(String sentance) {
        StringTokenizer tokenizer = new StringTokenizer(sentance);
        StringBuilder sb = new StringBuilder();
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            String slang = getSlang(word);
            sb.append(slang != null ? slang : word);
            sb.append(tokenizer.hasMoreTokens() ? " " : "");
        }
        return sb.toString();
    }

    private String getSlang(String word) {
        return getSlangMap().get(word);
    }

    protected abstract Map<String, String> getSlangMap();
}


public class Aussi extends Person {
    @Override
    protected Map<String, String> getSlangMap() {
        Map<String, String> slangMap = new HashMap<>();
        slangMap.put("hi", "Oi");
        slangMap.put("there", "theeer");
        return slangMap;
    }
}

public class Swede extends Person {
    @Override
    protected Map<String, String> getSlangMap() {
        Map<String, String> slangMap = new HashMap<>();
        slangMap.put("hi", "hejsan");
        slangMap.put("there", "där");
        return slangMap;
    }
}

public class CommunityTest {
    @Test
    public void testSayHiThere() throws Exception {
        Aussi au1 = new Aussi();
        Aussi au2 = new Aussi();
        Community<Aussi> aussiCommunity = new Community<>();
        aussiCommunity.add(au1);
        aussiCommunity.add(au2);

        Swede sw1 = new Swede();
        Swede sw2 = new Swede();
        Community<Swede> swedeCommunity = new Community<>();
        swedeCommunity.add(sw1);
        swedeCommunity.add(sw2);

        List<Community<? extends Person>> communities = new ArrayList<>();
        communities.add(aussiCommunity);
        communities.add(swedeCommunity);

        for (Community<? extends Person> community : communities) {
            for (Person person : community.getPeople()) {
                System.out.println(person.say("hi there"));
            }
        }
    }
}