public interface FailureStrategy {
    void fail (String message);
}

enum Failure implements FailureStrategy {
    Ignore {

        @Override
        public void fail(String message) {
            // Do nothing on success.
        }

    },
    LogToConsole {

        @Override
        public void fail(String message) {
            System.out.println(message);
        }

    },
    ErrToConsole {

        @Override
        public void fail(String message) {
            System.err.println(message);
        }

    },
    RingAlarmBells {

        @Override
        public void fail(String message) {
            // Left to the student.
        }

    },
    SoundTheKlaxon {

        @Override
        public void fail(String message) {
            // Left to the student.
        }

    },
    EndTheWorld {

        @Override
        public void fail(String message) {
            // Left to the student.
        }

    };
}

public class SomethingLethal {
    public FailureStrategy onFail = Failure.EndTheWorld;
}

public class SomethingDangerous {
    public FailureStrategy onFail = Failure.RingAlarmBells;
}

public class SomethingBenign {
    public FailureStrategy onFail = Failure.Ignore;
}