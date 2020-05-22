private class Cont {
        Integer born;
        Integer died;

        public Cont(String input) throws Exception {
            String[] values = input.split(":");
            if (values.length == 2) {
                born = Integer.parseInt(values[0]);
                died = Integer.parseInt(values[1]);
            } else if (values.length == 1) {
                born = Integer.parseInt(values[0]);
            } else {
                throw new Exception("bad input");
            }
        }
    }

public void doWork() {
    List<String> in = new ArrayList<>();
    in.add("1902:1991");
    in.add("1941:1978");
    in.add("2004:");
    in.add("1957:");
    in.add("1989:2008");
    in.add("1909:2005");
    in.add("1918:");
    in.add("1913:2010");
    in.add("1979:");
    in.add("1961:2002");
    in.add("1977:2003");
    in.add("1909:1991");
    List<Cont> entries = new ArrayList<>();
    for (String inp : in) {
        try {
            entries.add(new Cont(inp));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int bornCount = 0;
    int deathCount = 0;
    int aliveCount = bornCount - deathCount;
    for (int i = 1900; i < 2019; i++) {
        int prevAlive = aliveCount;
        for (Cont c : entries) {
            if (i == c.born) {
                bornCount++;
            } else if (c.died != null && i == c.died) {
                deathCount++;
            }
        }
        aliveCount = bornCount - deathCount;
        if (prevAlive > aliveCount) {
            System.out.println(i);
        }
    }

}