Map<Integer, Map<Character, Float>> probabilities = new TreeMap<>(Map.of(
        0, Map.of('a', 0.25f),
        1, Map.of('"', 0.5f),
        2, Map.of('s', 0.625f),
        3, Map.of('{', 0.75f),
        4, Map.of('�', 0.875f),
        5, Map.of('}', 1.0f)
));
System.out.println("probabilities = " + probabilities);

String input = "{0={a=0.25}, 1={\"=0.5}, 2={s=0.625}, 3={{=0.75}, 4={�=0.875}, 5={}=1.0}}";
System.out.println("input         = " + input);

Map<Integer, Map<Character, Float>> output = parse(input);
System.out.println("output        = " + output);