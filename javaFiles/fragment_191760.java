import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assume;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

@Slf4j
final class CircleCiParallelRule implements TestRule {
    @Override
    public Statement apply(Statement statement, Description description) {

        boolean runTest = true;

        final String tName = description.getClassName() + "#" + description.getMethodName();

        final String numNodes = System.getenv("CIRCLE_NODE_TOTAL");
        final String curNode = System.getenv("CIRCLE_NODE_INDEX");

        if (StringUtils.isBlank(numNodes) || StringUtils.isBlank(curNode)) {
            log.trace("Running locally, so skipping");
        } else {
            final int hashCode = Math.abs(tName.hashCode());

            int nodeToRunOn = hashCode % Integer.parseInt(numNodes);
            final int curNodeInt = Integer.parseInt(curNode);

            runTest = nodeToRunOn == curNodeInt;

            log.trace("currentNode: " + curNodeInt + ", targetNode: " + nodeToRunOn + ", runTest: " + runTest);

            if (!runTest) {
                return new Statement() {
                    @Override
                    public void evaluate() throws Throwable {
                        Assume.assumeTrue("Skipping test, currentNode: " + curNode + ", targetNode: " + nodeToRunOn, false);
                    }
                };
            }
        }

        return statement;
    }
}