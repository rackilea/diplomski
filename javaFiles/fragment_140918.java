import javax.annotation.CheckReturnValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@CheckReturnValue
class A {
  String a() { return "a"; }

  @CanIgnoreReturnValue
  String b() { return "b"; }

  void run() {
    a(); // Warning
    b(); // No warning
  }
}