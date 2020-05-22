@Component
@RequiredArgsConstructor
class MyComponent implements MyComponentInterface {

  private final @NonNull MyDependency dependency;

  …
}