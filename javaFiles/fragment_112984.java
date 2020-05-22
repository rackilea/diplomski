package basic;

import java.util.HashMap;
import java.util.Map;

public class My2DArray<T> {

    private final int row;
    private final int column;
    private final T placeholder;
    private final boolean[][] isSet;
    private final Map<Integer, T> data;

    public My2DArray(int row, int column, T placeholder) {
        this.row = row;
        this.column = column;
        this.placeholder = placeholder;
        isSet = new boolean[row][column];
        data = new HashMap<>();
    }

    public void set(int i, int j, T value) {
        if (i < row && i >= 0 && j < column && j >= 0) {
            isSet[i][j] = true;
            data.put(i * column + j, value);
        }
    }

    public T get(int i, int j) {
        if (i < row && i >= 0 && j < column && j >= 0) {
            if (isSet[i][j]) {
                return data.get(i * column + j);
            } else {
                return placeholder;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sb.append(get(i, j));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}