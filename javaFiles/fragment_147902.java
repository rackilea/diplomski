import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class YearTempsTest {
    private static final String [] yearTemp = new String [] {
        "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958",
        "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966",
        "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974",
        "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982",
        "1983", "1984", "1985", "1987", "1988", "1989", "1990", "1991",
        "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999",
        "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007",
        "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015",
        "2016"};

    private static final int [] highLowTemp = new int [] {
        7, 68,  9, 77, 20, 65, -7, 63, -3, 66, 8, 62, -2, 63, 3, 58,
        -5, 69, 8, 70, -12, 58, -12, 71, -28, 67, -6, 66, -14, 68, -15, 62,
        10, 73, 0, 64, -12, 60, -14, 66, 7, 67, -8, 71, 0, 62, 13, 69,
        6, 70, -3, 57, -13, 41, -6, 60, 0, 60, 15, 56, -2, 62, -19, 62,
        11, 57, -2, 61, -16, 63, -7, 62, -2, 61, 18, 67,  13, 68, 14, 62,
        4, 58, 12, 67, -32, 54, 3, 69, 7, 68, -2, 68, 6, 66, 4, 73,
        5, 69,  3, 61, 11, 72, -8, 57, 1, 70, 6, 69, 15, 65, 7, 67,
        1, 70, 0, 60, 2, 57, 3, 62, 15, 64, 14, 68, -4, 57, 2, 59,
        5, 64};

    public static void main (String [] args) {
        new YearTempsTest().buildGui();
    }

    private void buildGui () {
        JFrame dialog = new JFrame("Year & temps");
        JComboBox<String> yearCombo = new JComboBox<>(yearTemp);
        yearCombo.addItemListener(new YearItemListener());
        dialog.add(yearCombo);  
        dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dialog.setLocation(300, 200);
        dialog.setSize(300, 100);
        dialog.setVisible(true);
    }

    private class YearItemListener implements ItemListener {
        @Override public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String year = (String) e.getItem();
                // get index of year array
                int ix = Arrays.binarySearch(yearTemp, year, Comparator.naturalOrder());
                // get the high low temps using year array index
                int lowTemp = highLowTemp [ix*2];
                int highTemp = highLowTemp [ix*2 + 1];
                // work with the two temp values (show in a text field, etc.)
                System.out.println(year + " -> " + lowTemp + " :: " + highTemp);
            }
        }
    }
}