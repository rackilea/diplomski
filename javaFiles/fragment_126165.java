if (argv.length > 0) {
            try {
                long time = Long.parseLong(argv[0]) * 1000L;
                System.out.println("ScreenShot in " + argv[0] + " second(s)...");
                Thread.sleep(time);
                System.out.println("Snap!");
            } catch (NumberFormatException nfe) {
                System.err.println(argv[0] + " is not a valid number of seconds.");
                System.exit(-1);
            }
        }
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        Robot robot = new Robot();
        BufferedImage img = robot.createScreenCapture(new Rectangle(size));
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JLabel(new ImageIcon(img)));

        frame.pack();
        frame.setVisible(true);