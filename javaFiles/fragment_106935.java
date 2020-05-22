public class FrameA extends JFrame {
    private FrameB frameB;

    public void setFrameB(FrameB frameB) {
        this.frameB = frameB;
    }

    public void foo() {
        // change things in this frame
        frameB.doSomethingBecauseFrameAHasChanged();
    }
}

public class FrameB extends JFrame {
    private FrameA frameA;

    public void setFrameA(FrameA frameA) {
        this.frameA = frameA;
    }

    public void bar() {
        // change things in this frame
        frameA.doSomethingBecauseFrameBHasChanged();
    }
}

public class Main {
    public static void main(String[] args) {
        FrameA frameA = new FrameA();
        FrameB frameB = new FrameB();
        frameA.setFrameB(frameB);
        frameB.setFrameA(frameA);
        // make both frames visible
    }
}