import java.sql.*;
import org.apache.commons.lang3.*;

public class doQuery {

    public static void main (String[] args) {
        ...
        try {
            ...
        } catch (Exception e) {
            ...
        }
        try {
            ...
            try {
                ...
            } catch (SQLException e) {
                ...
            } finally {
                ...
            }
        } catch (SQLException e) {
            ...
        }
        displayNumber(4); // Replace 4 with a variable to output or what not
    }

    private int displayNumber(int number) {
        return number;
    }
}