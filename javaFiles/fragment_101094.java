String t1 = "I am <pair-starter> first second <pair-ender>, <pair-starter> and";
String t2 = " hopefully <pair-ender> it ends .";
split(Stream.of(t1, t2));

public void split(Stream<String> lines)
{
    PairResult result = lines.flatMap(Pattern.compile("[\\s]+")::splitAsStream)
                             .map(word -> word.replaceAll("[,.?!]", ""))
                             .filter(word -> !word.isEmpty())
                             .collect(new PairCollector());

    System.out.println(result.words);
    System.out.println(result.pairs);
}

// Output
// [I, am, first, second, and, hopefully, it, ends]
// {and=hopefully, first=second}

class PairCollector
    implements Collector<String, PairResult, PairResult>
{
    @Override
    public Supplier<PairResult> supplier()
    {
        return PairResult::new;
    }

    @Override
    public BiConsumer<PairResult, String> accumulator()
    {
        return (result, word) -> {
            if ("<pair-starter>".equals(word))
            {
                result.inPair = true;
            }
            else if ("<pair-ender>".equals(word))
            {
                if (result.inPair)
                {
                    result.pairs.put(result.words.get(result.words.size() - 2),
                                     result.words.get(result.words.size() - 1));
                    result.inPair = false;
                }
                else
                {
                    // starter must be in another result, keep ender for combiner
                    result.words.add(word);
                }
            }
            else
            {
                result.words.add(word);
            }
        };
    }

    @Override
    public BinaryOperator<PairResult> combiner()
    {
        return (result1, result2) -> {
            // add completed pairs
            result1.pairs.putAll(result2.pairs);

            // use accumulator to finish split pairs
            BiConsumer<PairResult, String> acc = accumulator();
            result2.words.forEach(word2 -> acc.accept(result1, word2));

            return result1;
        };
    }

    @Override
    public Function<PairResult, PairResult> finisher()
    {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics()
    {
        return new HashSet<>(Arrays.asList(Characteristics.IDENTITY_FINISH));
    }
}

class PairResult
{
    public boolean                   inPair;
    public final List<String>        words = new ArrayList<>();
    public final Map<String, String> pairs = new HashMap<>();
}