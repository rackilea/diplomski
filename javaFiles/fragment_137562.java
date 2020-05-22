import android.app.Fragment;
import android.util.Log;
import java.util.HashMap;

public class TestHashMap {

      private HashMap<Fragment, Integer> test = new HashMap<>();

      public static class ExampleFragment extends Fragment {
          public ExampleFragment() { super(); }
          public String toString() { return "ExampleFragment[hash:"+hashCode()+"]"; }
          public void someOtherMethod() {}
      }

      public static class AnotherFragment extends Fragment {
          public AnotherFragment() { super(); }
          public String toString() { return "AnotherFragment[hash:"+hashCode()+"]"; }
      }

      public void test() {
          test.put(new ExampleFragment(),1);
          test.put(new AnotherFragment(),2);
          Log.d("TestHashMap","size = "+test.size());
          Log.d("TestHashMap",test.toString());
      }
  }