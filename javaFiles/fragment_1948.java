import static org.assertj.core.api.Assertions.assertThat;
import org.junit.runner.RunWith;
import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;

@RunWith(ZohhakRunner.class)
public class SampleTest {

    Sample sample = new Sample();

    @TestWith({
        "true,  3,      true",
        "true,  2,      false",
        "false, 3,      true",
        "false, 2,      true",
        "false, 1,      false"
    })
    public void should_xxx(boolean isLive, int num, boolean expectedResult) {

        boolean actualResult = sample.isALive(isLive, num);         
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}