public void StartBouncingBallTest() {
    timer.start();
}

//...

class TimerListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (x > 0 && y > 0) {
            x += dx;
            y += dy;
        }

        else if (x == 0) {
            x -= dx;
            y += dy;
        }

        else if (y + (2 * radius) > getHeight()) {
            x += dx;
            y -= dy;
        }

        else if (y == 0) {
            x += dx;
            y -= dy;
        }

        else if (x + (2 * radius) > getWidth()) {
            x -= dx;
            y += dy;
        }
        repaint();
    }
}