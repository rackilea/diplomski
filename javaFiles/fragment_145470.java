public class ShaderTest {
    private final Color shader;

    public ShaderTest(final Color shader) {
        this.shader = shader;
    }

    public  BufferedImage applyShader(BufferedImage input) {
        BufferedImage output = new BufferedImage(input.getWidth(), input.getHeight(), BufferedImage.TYPE_INT_ARGB);
        float red = shader.getRed();
        float green = shader.getGreen();
        float blue = shader.getBlue();
        if(red > 0.0f) red = 255.0f / red * 100f;
        if(green > 0.0f) green = 255.0f / green * 100f;
        if(blue > 0.0f) blue = 255.0f / blue * 100f;
        System.out.println(red + ", " + green + ", " + blue);

        float[] factors = new float[] {
                1.0f, 1.0f, 1.0f, 1.0f
        };

        float[] offsets = new float[] {
                red, green, blue, 0
        };

        RescaleOp op = new RescaleOp(factors, offsets, null);
        return op.filter(input, output);
    }

    // Test code
    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File(args[0]));
        final BufferedImage shaded = new ShaderTest(Color.ORANGE).applyShader(image);

        // Show shaded image
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("ShaderTest");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.add(new JLabel(new ImageIcon(shaded)));

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}