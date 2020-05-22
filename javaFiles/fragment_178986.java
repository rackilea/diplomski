import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

// ...

verify(dependency, never()).someMethod();