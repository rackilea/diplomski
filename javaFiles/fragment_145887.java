while ((m.atExit(x1, y1)) == false) {
        if (m.wallAtLeft(dir, x1, y1) == true) {
            t.forward(1);
            SimpleWindow.delay(10);
        }

        else if (m.wallAtLeft(dir, x1, y1) == false) {
            t.left(90);
            t.forward(1);
            SimpleWindow.delay(10);
        }

        if (m.wallInFront(dir, x1, y1) == true) {
            t.left(-90);
            t.forward(1);
        }