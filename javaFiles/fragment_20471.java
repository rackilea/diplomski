import java.util.Arrays;
import java.util.List;
import java.util.Optional;

int max(List<Integer> list) {
  Optional<Integer> opt = list.stream().max((a,b) -> a-b);
  return opt.orElse(Integer.MAX_VALUE);
}

max(Arrays.asList(-13, 12, 1337, 9)); // 1337
max(Arrays.asList()); // 2147483647