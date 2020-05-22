import static com.google.common.collect.ImmutableSortedSet.toImmutableSortedSet;
import static java.util.Comparator.naturalOrder;

Quest.QUESTS.stream()
   .map(quest -> copy(quest))
   .collect(toImmutableSortedSet(naturalOrder()));