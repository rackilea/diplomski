Map<Pair, Pair> pairMap = new HashMap<Pair, Pair>();

    for (String line : lines) {
        String[] lineparts = line.split(",");

        if (line.startsWith("Date") || lineparts[3].equals("0.00") || lineparts[3].equals("-0.00")
                || lineparts[3].equals("000") || lineparts[3].equals("0000") || lineparts[3].equals("00000")) {
            continue;
        }

        String description = lineparts[4];
        String acct = lineparts[2];
        String amt = lineparts[3];

        Pair newPair = new Pair(description, acct, amt);
        if (!pairMap.containsKey(newPair)) {
            pairMap.put(newPair, newPair);
        } else {
            Pair existingPair = pairMap.get(newPair);
            String mergedAmount = existingPair.getAmount() + newPair.getAmount();
            existingPair.setAmount(mergedAmount);
        }
    }

    Set<Pair> mergedPairs = pairMap.keySet();