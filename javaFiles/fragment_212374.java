import static org.junit.Assume.*;
public class TestMySubClass extends TestSuperClass{

    @Before
    public void makesureDirectoryCopied(){

       assumeTrue( directoryCopied());
   }

   ...