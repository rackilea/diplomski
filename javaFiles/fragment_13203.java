@RequiredArgsConstructor// Lombok, otherwise write the boilerplate yourself
public class BinaryOperator<T, T> {
   @NonNull private final BiFunction<T, T> op;
   @NonNull private final Class<T> clazz;

   public boolean isApplicable(Object left, Object right) {
       return clazz.isInstance(left) && clazz.isInstance(right);
   }

   public T apply(Object left, Object right) {
       return op.apply(clazz.cast(left), clazz.cast(right));
   }
}