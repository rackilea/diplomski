import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

class RepeatTest {

    @BeforeEach
    void setUp(RepetitionInfo repetitionInfo, TestInfo testInfo) {
        if (repetitionInfo.getCurrentRepetition() == 1) {
            System.out.println("Before repetition of " + testInfo.getDisplayName());
        }
    }

    @RepeatedTest(value = 3, name = "{displayName}_{currentRepetition}of{totalRepetitions}") @DisplayName("test1")
    void test1(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    @RepeatedTest(value = 5, name = "{displayName}_{currentRepetition}of{totalRepetitions}") @DisplayName("test2")
    void test2(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    @AfterEach
    void tearDown(RepetitionInfo repetitionInfo, TestInfo testInfo) {
        if (repetitionInfo.getCurrentRepetition() == repetitionInfo.getTotalRepetitions()) {
            System.out.println("After repetition of " + testInfo.getDisplayName());
        }
    }
}