#parse("File Header.java")
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import static org.junit.Assert.*;

public class ${NAME} {
  ${BODY}
}