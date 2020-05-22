import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author yccheok
 */
public class Board {
    private Board(String board) {
        this.board = board;
    }

    public static Board newInstance(String board) {
        if (board == null) {
            throw new java.lang.IllegalArgumentException("board cannot be null");
        }

        Board result = map.get(board);
        if (result == null) {
            final Board instance = new Board(board);
            result = map.putIfAbsent(board, instance);
            if (result == null) {
                return instance;
            }
        }

        assert(result != null);
        return result;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + board.hashCode();

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Board)) {
            return false;
        }

        return this.board.equals(((Board)o).board);
    }

    @Override
    public String toString() {
        return board;
    }

    // Avoid using interface. We want it to be fast!
    private static final ConcurrentHashMap<String, Board> map = new ConcurrentHashMap<>();
    private final String board;
}