while (true) {

        window.label.setText("Lazy cat");
        window.update(window.getGraphics());//<------ new line
        window.setVisible(true);
        pause();
        window.setVisible(false);
        pause();

        window.label.setText(sb.toString());
        window.update(window.getGraphics());//<------ new line
        window.setVisible(true);
        pause();
        window.setVisible(false);
        pause();
    }