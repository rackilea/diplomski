#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")
import org.testng.annotations.Test;
public class ${NAME} {
    @Test
    public void testGeneratedStub () {      
        $END$
    }
}