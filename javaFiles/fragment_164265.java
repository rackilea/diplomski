public class Piece
            {
                private char icon;
                public char getIcon() { return icon; }
                public void setIcon(char i) { icon = i; }
                public Piece(char c) { setIcon(c); }
            }

            public class Pawn extends Piece
            {
                public Pawn()
                {
                    super('I');
                }
            }