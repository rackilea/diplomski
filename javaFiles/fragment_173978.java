public static final String
    ROTCW = "xrandr -o left",
    CALCW1[] = {"xinput", "--set-prop", "11", "\"Evdev Axis Inversion\"", "0", "1"},
    CALCW2[] = {"xinput", "--set-prop", "11", "\"Evdev Axes Swap\"", "1"};

public void actionPerformed(ActionEvent e)
{       
    try {
        Runtime.getRuntime().exec(ROTCW).waitFor();
        Process p = Runtime.getRuntime().exec(CALCW1);
        p.waitFor();
        if( p.exitValue() != 0 ) Runtime.getRuntime().exec(CALCW2);
    }
    catch (IOException ioe){ ioe.printStackTrace();}
}});