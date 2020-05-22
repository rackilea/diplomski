import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;

@Fork(3)
@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 10, timeUnit = TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Threads(1)
@Warmup(iterations = 5, timeUnit = TimeUnit.NANOSECONDS)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MyBenchmark {

  private static final String[] TEST_ARRAY = { "a", "b", "c", "d", "e", "f" };
  private static final int NEW_LENGTH = 10_000;

  @Benchmark
  public String[] testNativeCall() {
    String[] dup = Arrays.copyOf(TEST_ARRAY, NEW_LENGTH);
    for (int last = TEST_ARRAY.length; last != 0 && last < NEW_LENGTH; last <<= 1) {
      System.arraycopy(dup, 0, dup, last, Math.min(last << 1, NEW_LENGTH) - last);
    }
    return dup;
  }

  @Benchmark
  public String[] testLoopModulo() {
    String[] arr = new String[NEW_LENGTH];
    for (int i = 0; i < NEW_LENGTH; i++) {
      arr[i] = arr[i % TEST_ARRAY.length];
    }
    return arr;
  }

  @Benchmark
  public String[] testArrayList() {
    List<String> initialLetters = Arrays.asList(TEST_ARRAY);
    List<String> results = new ArrayList<>();
    int indexOfLetterToAdd = 0;
    for (int i = 0; i < 10000; i++) {
      results.add(initialLetters.get(indexOfLetterToAdd++));
      if (indexOfLetterToAdd == initialLetters.size()) {
        indexOfLetterToAdd = 0;
      }
    }
    return results.toArray(new String[results.size()]);
  }

  @Benchmark
  public String[] testLoopReset() {
    String result[] = new String[NEW_LENGTH];
    for (int i = 0, j = 0; i < NEW_LENGTH && j < TEST_ARRAY.length; i++, j++) {
      result[i] = TEST_ARRAY[j];
      if (j == TEST_ARRAY.length - 1) {
        j = -1;
      }
    }
    return result;
  }

  @Benchmark
  public String[] testStream() {
    String[] result = Stream.iterate(TEST_ARRAY, x -> x).flatMap(x -> Stream.of(TEST_ARRAY)).limit(NEW_LENGTH)
        .toArray(String[]::new);
    return result;
  }
}