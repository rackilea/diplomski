ColorSensor cs = new ColorSensor(SensorPort.S1);
Color color = cs.getColor();
String text;

if (color.getGreen()>color.getRed() && color.getGreen()>color.getBlue()) {
    text="green";
} else if (color.getBlue()>color.getRed() && color.getBlue()>color.getGreen()) {
    text="blue";
} else {
    text="red";
}