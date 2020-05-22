public class ChartGenerator extends Application {

    private static Canvas canvas;

    private static volatile byte[] result;

    public static void initialize(TaskExecutor taskExecutor) {
        taskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                launch(ChartGenerator.class);
            }
        });
    }

    public static synchronized byte[] generateChart(final Object... params) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ByteArrayOutputStream baos = null;
                try {
                    GraphicsContext gc = canvas.getGraphicsContext2D();
                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    /**
                     * Do the work with canvas
                     **/
                    final SnapshotParameters snapshotParameters = new SnapshotParameters();
                    snapshotParameters.setFill(Color.TRANSPARENT);
                    WritableImage image = canvas.snapshot(snapshotParameters, null);
                    BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
                    baos = new ByteArrayOutputStream();
                    ImageIO.write(bImage, chartType.outputFormat, baos);
                    result = baos.toByteArray();
                } catch (InstantiationException e) {
                    throw new ChartGenerationException(e);
                } catch (IllegalAccessException e) {
                    throw new ChartGenerationException(e);
                } catch (NoSuchMethodException e) {
                    throw new ChartGenerationException(e);
                } catch (InvocationTargetException e) {
                    throw new ChartGenerationException(e);
                } catch (IOException e) {
                    throw new ChartGenerationException(e);
                } finally {
                    IOUtils.closeQuietly(baos);
                }
            }
        });
        while (result == null) {
            //wait
        }
        byte[] ret = result;
        result = null;
        return ret;
    }


    @Override
    public void start(Stage stage) {
        canvas = new Canvas();
    }

    public static class ChartGenerationException extends RuntimeException {
        public ChartGenerationException(String message) {
            super(message);
        }
        public ChartGenerationException(Throwable cause) {
            super(cause);
        }
    }

}