ChronicleMap<String, String> lexicalizationGraph = ChronicleMap 
                .of(String.class, String.class)
                .name("lexicalizations-chronicle-map")
                .constantKeySizeBySample("bn:14271053n")
                .averageValue("average size of value")
                .entries(1_000_000_000L)
                .createPersistedTo(file);