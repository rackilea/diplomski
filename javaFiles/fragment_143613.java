@RunWith(Theories.class)
public class SnippetTest {

    @DataPoints
    public static boolean[] data(){
        return new boolean[]{false, true};
    }

   @Theory
   public void validateIndices(boolean data){
       assumeTrue(data);
       assertTrue(true);
   }
}