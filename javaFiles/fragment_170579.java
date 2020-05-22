public class Global {
  public static final Lock webLock = new ReentrantLock();
}

public class ClassA {
    public void go() {
        Global.webLock.lock()
        try {
            // do A stuff
        } finally {
            Global.webLock.unlock()
        }
    }
}

public class ClassB {
    public void go() {
        Global.webLock.lock()
        try {
            // do B stuff
        } finally {
            Global.webLock.unlock()
        }
    }
}

public class ClassC {
    public void go() {
        Global.webLock.lock()
        try {
            // do C stuff
        } finally {
            Global.webLock.unlock()
        }
    }
}