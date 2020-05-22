package uk.co.scottdennison.java.testbed;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import uk.co.scottdennison.java.testbed.TextUtilities.CircularTextPosition;
import uk.co.scottdennison.java.testbed.TextUtilities.GlyphDrawer;

import static uk.co.scottdennison.java.testbed.TextUtilities.CircularTextPosition.BASELINE_ON_CIRCLE;
import static uk.co.scottdennison.java.testbed.TextUtilities.CircularTextPosition.INSIDE_CIRCLE;
import static uk.co.scottdennison.java.testbed.TextUtilities.CircularTextPosition.OUTSIDE_CIRCLE;

public class CreateText4 {
    private static final int IMAGE_SIZE = 364;
    private static final Color BACKGROUND_COLOUR = new Color(242,247,254);
    private static final Font FONT = new Font("Arial",Font.BOLD,48);
    private static final Stroke STROKE = new BasicStroke(1f);
    private static final Color UPPER_TEXT_FILL_COLOUR = Color.WHITE;
    private static final Color UPPER_TEXT_OUTLINE_COLOUR = Color.RED;
    private static final Color LOWER_TEXT_FILL_COLOUR = Color.WHITE;
    private static final Color LOWER_TEXT_OUTLINE_COLOUR = Color.BLUE;

    public static void main(String[] args) throws IOException {
        for (CircularTextPosition textPosition : CircularTextPosition.values()) {
            for (int squash=0; squash<=1; squash++) {
                for (int angle=0; angle<360; angle+=15) {
                    int edgeGap = 0;
                    switch (textPosition) { // For the demo, the edge gaps need to be different, but the enum in TextUtilities could be in a completely separate library so should have no knowledge of this.
                        case INSIDE_CIRCLE:
                            edgeGap = 10;
                            break;
                        case BASELINE_ON_CIRCLE:
                            edgeGap = 40;
                            break;
                        case OUTSIDE_CIRCLE:
                            edgeGap = 70;
                            break;
                    }
                    draw(angle,edgeGap,squash==1,textPosition);
                }
            }
        }
    }

    public static void draw(int angle, int edgeGap, boolean squash, CircularTextPosition circularTextPosition) throws IOException {
        System.out.println("angle=" + angle + " / squash=" + squash + " / circularTextPosition=" + circularTextPosition);
        BufferedImage bi = new BufferedImage(IMAGE_SIZE,IMAGE_SIZE,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D)bi.getGraphics();

        double center = IMAGE_SIZE/2.0;
        double radius = center-edgeGap;
        int flooredCenter = (int)Math.floor(center);
        int ceiledCenter = (int)Math.ceil(center);

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(BACKGROUND_COLOUR);
        g.fillRect(-1,-1,IMAGE_SIZE+2,IMAGE_SIZE+2);

        g.setStroke(new BasicStroke(1f));

        g.setColor(Color.GREEN);
        g.drawLine(0, 0, IMAGE_SIZE, IMAGE_SIZE);
        g.drawLine(flooredCenter, 0, flooredCenter, IMAGE_SIZE);
        if (flooredCenter != ceiledCenter) {
            g.drawLine(flooredCenter-1, 0, flooredCenter-1, IMAGE_SIZE);
        }
        g.drawLine(IMAGE_SIZE, 0, 0, IMAGE_SIZE);
        g.drawLine(0, flooredCenter, IMAGE_SIZE, flooredCenter);
        if (flooredCenter != ceiledCenter) {
            g.drawLine(0, flooredCenter-1, IMAGE_SIZE, flooredCenter-1);
        }

        g.setColor(Color.RED);
        g.drawOval((int)(center-radius),(int)(center-radius),(int)(radius+radius-1),(int)(radius+radius-1));

        TextUtilities.drawTextAroundCircle(g,"Top y Text"   ,angle,squash,circularTextPosition,false,radius,center,center,FONT,new OutlinedFilledGlyphDrawer(UPPER_TEXT_FILL_COLOUR,UPPER_TEXT_OUTLINE_COLOUR,STROKE));
        TextUtilities.drawTextAroundCircle(g,"Bottom y Text",angle,squash,circularTextPosition,true ,radius,center,center,FONT,new OutlinedFilledGlyphDrawer(LOWER_TEXT_FILL_COLOUR,LOWER_TEXT_OUTLINE_COLOUR,STROKE));

        ImageIO.write(bi, "png", new File(String.format("test_%s_%s_%03d.png", circularTextPosition.name().toLowerCase().replace("_","-"),squash?"squashed":"normal",angle)));
    }

    public static class OutlinedFilledGlyphDrawer implements GlyphDrawer {
        private Color oldGraphicsStateColor;
        private Stroke oldGraphicsStateStroke;
        private final Color fillColour;
        private final Color outlineColour;
        private final Stroke stroke;

        public OutlinedFilledGlyphDrawer(Color fillColour, Color outlineColour, Stroke stroke) {
            this.fillColour = fillColour;
            this.outlineColour = outlineColour;
            this.stroke = stroke;
        }

        @Override
        public void saveGraphicsStateBeforeDraw(Graphics2D g) {
            this.oldGraphicsStateColor = g.getColor();
            this.oldGraphicsStateStroke = g.getStroke();
        }

        @Override
        public void drawGlyph(Graphics2D preTransformedG, Shape glyph) {
            preTransformedG.setColor(this.fillColour);
            preTransformedG.fill(glyph);
            preTransformedG.setColor(this.outlineColour);
            preTransformedG.setStroke(this.stroke);
            preTransformedG.draw(glyph);
        }

        @Override
        public void restoreGraphicsStateAfterDraw(Graphics2D g) {
            g.setColor(this.oldGraphicsStateColor);
            g.setStroke(this.oldGraphicsStateStroke);
        }
    }
}

class TextUtilities { // Ideally separate into it's own package rather and then don't use static inner classes, but for this single-file demo, it works.
    public static enum CircularTextPosition {
        OUTSIDE_CIRCLE {
            @Override
            double calculateActualRadius(double radius, double maxAscent, double maxDescent, boolean flip) {
                return radius;
            }
        },
        BASELINE_ON_CIRCLE {
            @Override
            double calculateActualRadius(double radius, double maxAscent, double maxDescent, boolean flip) {
                return radius-(flip?maxAscent:maxDescent);
            }
        },
        INSIDE_CIRCLE {
            @Override
            double calculateActualRadius(double radius, double maxAscent, double maxDescent, boolean flip) {
                return radius-maxAscent-maxDescent;
            }
        };

        abstract double calculateActualRadius(double radius, double maxAscent, double maxDescent, boolean flip);
    }

    public static interface GlyphDrawer {
        void saveGraphicsStateBeforeDraw(Graphics2D g);
        void drawGlyph(Graphics2D preTransformedG, Shape glyph);
        void restoreGraphicsStateAfterDraw(Graphics2D g);
    }

    public static void drawTextAroundCircle(Graphics2D g, String text, int centerAngleInDegrees, boolean squash, CircularTextPosition circularTextPosition, boolean flip, double radius, double centerX, double centerY, Font font, GlyphDrawer glyphDrawer) {
        AffineTransform oldTransform = g.getTransform();
        glyphDrawer.saveGraphicsStateBeforeDraw(g);

        FontMetrics fm = g.getFontMetrics(font);
        FontRenderContext frc = g.getFontRenderContext();

        char[] characters = text.toCharArray();
        int characterCount = characters.length;
        if (flip) {
            char[] reversedCharacters = new char[characterCount];
            for (int index=0; index<characterCount; index++) {
                reversedCharacters[index] = characters[characterCount-index-1];
            }
            characters = reversedCharacters;
        }

        double maxAscent;
        double maxDescent;
        if (squash) {
            maxAscent = 0;
            maxDescent = 0;
        } else {
            maxAscent = fm.getMaxAscent();
            maxDescent = fm.getMaxDescent();
        }

        double spaceCharacterWidth = fm.charWidth('n');
        double leading = fm.getLeading();
        boolean[] charactersAreSpaces = new boolean[characterCount];
        GlyphVector[] characterGlyphVectors = new GlyphVector[characterCount];
        Rectangle2D[] characterGlyphBounds = new Rectangle2D[characterCount];
        double[] characterWidths = new double[characterCount+1];
        double[] characterAscents = new double[characterCount];
        double[] characterDescents = new double[characterCount];
        for (int index=0; index<characterCount; index++) {
            char character = characters[index];

            boolean isSpace = character == ' ' || Character.isSpaceChar(character);
            GlyphVector glyphVector = font.createGlyphVector(frc, Character.toString(character));
            Rectangle2D glyphBounds = glyphVector.getVisualBounds();
            double width = isSpace?spaceCharacterWidth:glyphBounds.getWidth();
            double ascent = -glyphBounds.getY();
            double descent = glyphBounds.getHeight()-ascent;

            charactersAreSpaces[index] = isSpace;
            characterGlyphVectors[index] = glyphVector;
            characterGlyphBounds[index] = glyphBounds;
            characterWidths[index] = width;
            characterAscents[index] = ascent;
            characterDescents[index] = descent;

            if (squash) {
                maxAscent = Math.max(maxAscent,ascent);
                maxDescent = Math.max(maxDescent,descent);
            }
        }

        double actualRadius = circularTextPosition.calculateActualRadius(radius, maxAscent, maxDescent, flip);

        double currentAngleInRadians = 0;
        double[] characterAnglesInRadians = new double[characterCount];
        for (int index=0; index<characterCount; index++) {
            characterAnglesInRadians[index] = currentAngleInRadians;
            currentAngleInRadians += Math.sin(((characterWidths[index]/2.0) + leading + (characterWidths[index+1]/2.0)) / actualRadius);
        }
        double angleAdjustment = (centerAngleInDegrees * Math.PI / 180) - ((characterAnglesInRadians[characterCount-1] - characterAnglesInRadians[0]) / 2.0);
        for (int index=0; index<characterCount; index++) {
            characterAnglesInRadians[index] += angleAdjustment;
        }

        AffineTransform stringTransform = oldTransform;
        if (stringTransform == null) {
            stringTransform = new AffineTransform();
        }
        if (flip) {
            stringTransform.rotate(Math.PI, centerX, centerY);
        }

        for (int index=0; index<characterCount; index++) {
            if (!charactersAreSpaces[index]) {
                GlyphVector glyphVector = characterGlyphVectors[index];
                Rectangle2D glyphBounds = characterGlyphBounds[index];
                if (flip) {
                    AffineTransform oldGlyphVectorTransform = glyphVector.getGlyphTransform(0);
                    if (oldGlyphVectorTransform == null) {
                        oldGlyphVectorTransform = new AffineTransform();
                    }
                    AffineTransform newGlyphVectorTransform = new AffineTransform(oldGlyphVectorTransform);
                    newGlyphVectorTransform.scale(-1, -1);
                    newGlyphVectorTransform.translate(-(glyphBounds.getWidth()+glyphBounds.getX()+glyphBounds.getX()),glyphBounds.getHeight()+(maxAscent-characterAscents[index])-characterDescents[index]-maxDescent);
                    glyphVector.setGlyphTransform(0, newGlyphVectorTransform);
                }
                AffineTransform characterTransform = new AffineTransform(stringTransform);
                characterTransform.translate(centerX, centerY);
                characterTransform.rotate(characterAnglesInRadians[index]);
                characterTransform.translate(-((glyphBounds.getX()+(glyphBounds.getWidth()/2))),-(actualRadius+maxDescent));
                g.setTransform(characterTransform);
                glyphDrawer.drawGlyph(g, glyphVector.getOutline(0, 0));
            }
        }

        glyphDrawer.restoreGraphicsStateAfterDraw(g);
        g.setTransform(oldTransform);
    }
}