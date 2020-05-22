package com.ggl.testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CheckerBoard implements Runnable {

    private Board board;

    private CheckerBoardPanel checkerBoardPanel;

    private JFrame frame;

    private Pieces pieces;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new CheckerBoard());
    }

    public CheckerBoard() {
        this.board = new Board();
        this.pieces = new Pieces();
    }

    @Override
    public void run() {
        frame = new JFrame("Checker Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        checkerBoardPanel = new CheckerBoardPanel(board, pieces);
        frame.add(checkerBoardPanel);

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public class CheckerBoardPanel extends JPanel {

        private static final long serialVersionUID = 3770663347384271771L;

        private Board board;

        private Pieces pieces;

        public CheckerBoardPanel(Board board, Pieces pieces) {
            this.board = board;
            this.pieces = pieces;
            this.setPreferredSize(board.getPreferredSize());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Square[][] checkerBoard = board.getBoard();

            for (int row = 0; row < checkerBoard.length; row++) {
                for (int column = 0; column < checkerBoard[row].length; column++) {
                    Square square = checkerBoard[row][column];
                    Rectangle drawingRectangle = square.getDrawingRectangle();
                    g.setColor(square.getColor());
                    g.fillRect(drawingRectangle.x, drawingRectangle.y,
                            drawingRectangle.width, drawingRectangle.height);
                }
            }

            List<Piece> checkerPieces = pieces.getPieces();

            for (Piece checkerPiece : checkerPieces) {
                Point coordinate = checkerPiece.getCoordinate();
                Rectangle drawingRectangle = checkerBoard[coordinate.x][coordinate.y]
                        .getDrawingRectangle();

                int x = drawingRectangle.x + drawingRectangle.width / 2;
                int y = drawingRectangle.y + drawingRectangle.height / 2;
                int radius = board.getSquareWidth() * 2 / 6;

                g.setColor(checkerPiece.getColor());
                g.fillOval(x - radius, y - radius, radius + radius, radius
                        + radius);
            }
        }
    }

    public class Board {

        private static final int BOARD_WIDTH = 8;
        private static final int SQUARE_WIDTH = 64;

        private Square[][] board;

        public Board() {
            this.board = initalizeBoard(BOARD_WIDTH, SQUARE_WIDTH);
        }

        private Square[][] initalizeBoard(int boardWidth, int squareWidth) {
            Square[][] board = new Square[boardWidth][boardWidth];

            int x = 0;
            int y = 0;

            for (int row = 0; row < boardWidth; row++) {
                for (int column = 0; column < boardWidth; column++) {
                    Square square = new Square();
                    if (isLightSquare(row, column)) {
                        square.setColor(Color.WHITE);
                    } else {
                        square.setColor(Color.LIGHT_GRAY);
                    }

                    square.setCoordinate(new Point(row, column));
                    square.setDrawingRectangle(new Rectangle(x, y, squareWidth,
                            squareWidth));

                    board[row][column] = square;

                    x += squareWidth;
                }
                x = 0;
                y += squareWidth;
            }

            return board;
        }

        public boolean isLightSquare(int row, int column) {
            if (row % 2 == 0) {
                if (column % 2 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (column % 2 == 0) {
                    return false;
                } else {
                    return true;
                }
            }
        }

        public Dimension getPreferredSize() {
            int width = SQUARE_WIDTH * 8 + 1;
            return new Dimension(width, width);
        }

        public Square[][] getBoard() {
            return board;
        }

        public int getSquareWidth() {
            return SQUARE_WIDTH;
        }

    }

    public class Square {

        private Color color;

        private Point coordinate;

        private Rectangle drawingRectangle;

        public Point getCoordinate() {
            return coordinate;
        }

        public void setCoordinate(Point coordinate) {
            this.coordinate = coordinate;
        }

        public Rectangle getDrawingRectangle() {
            return drawingRectangle;
        }

        public void setDrawingRectangle(Rectangle drawingRectangle) {
            this.drawingRectangle = drawingRectangle;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

    }

    public class Pieces {

        private List<Piece> pieces;

        public Pieces() {
            this.pieces = addPieces();
        }

        private List<Piece> addPieces() {
            List<Piece> pieces = new ArrayList<Piece>();

            Piece piece = new Piece();
            piece.setColor(Color.RED);
            piece.setCoordinate(new Point(2, 1));
            pieces.add(piece);

            piece = new Piece();
            piece.setColor(Color.BLACK);
            piece.setCoordinate(new Point(5, 0));
            pieces.add(piece);

            // Add the rest of the red and black pieces here

            return pieces;
        }

        public List<Piece> getPieces() {
            return pieces;
        }

        public void addPiece(Piece piece) {
            this.pieces.add(piece);
        }
    }

    public class Piece {

        private Color color;

        private Point coordinate;

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public Point getCoordinate() {
            return coordinate;
        }

        public void setCoordinate(Point coordinate) {
            this.coordinate = coordinate;
        }

    }

}