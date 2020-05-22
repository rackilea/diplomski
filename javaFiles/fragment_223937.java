try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("frame");
        //it will keep this frame and its dialog always on top of the other frames/windows
        frame.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(
            frame,
            "test info",
            "test header",
            JOptionPane.INFORMATION_MESSAGE
        );