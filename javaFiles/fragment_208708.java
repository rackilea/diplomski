public class LEDDisplay
{
   private boolean[][] matrix;
   private static final int FONT_LETTER_HEIGHT = 5;
   private static final int FONT_LETTER_WIDTH = 6;
   private static final int LETTERS_PER_DISPLAY = 10;

public LEDDisplay()
{
    matrix = new boolean[FONT_LETTER_HEIGHT][FONT_LETTER_WIDTH * LETTERS_PER_DISPLAY];
}