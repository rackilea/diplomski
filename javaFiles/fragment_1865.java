import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GazillionSongs {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Java Song Collection!"); // greets the user
        System.out
                .println("This program sorts and filters large databases of popular songs."); // explains purpose of program
        System.out
                .println("This program is able to filter and sort by year, artist, title and rank.");
        System.out
                .println("Please enter a file that contains a database you wish to filter or sort. (i.e, alistofsongs.txt)"); // sample file = agazillionsongs.txt

        File f = new File("agazillionsongs.txt"); //creates file from input
      /*error check for file here*/
        Scanner fileScanner = new Scanner(f); //inputs data from file

        List<Song> songs = new ArrayList<Song>();
        while ((fileScanner.hasNextLine())) {
            Song song = Song.parse(fileScanner.nextLine());
            songs.add(song);
        }

        System.out
                .println("Please select which commands you would like to use for the program.");
        System.out
                .println("Please format your command like the following example: year:<year(s)> rank:<rank(s)> artist:<artist> title:<title> sortBy:<field>");
        System.out.println();
        System.out.println("You may pick any number of commands you want.");
        System.out
                .println("For years and rank, you may select a range of years or ranks.");
        System.out
                .println("For artists and titles, you may enter a partial name or title.");
        System.out.println("i.e, year:1983 rank:1");

        int n = 0;
        SongCollection collection = new SongCollection(songs);
        String inputType = "year:1983 sort:title";
        String delims = "[ ]";
        String[] tokens = inputType.split(delims);
        for (int i = 0; i < tokens.length; i++) {
            n = 0;
            if (n == 0) {
                if ((tokens[i]).contains("year:")) {
                    collection.filterYear(Range.parse(tokens[i]));
                    n = 1;
                }// end of year loop
                if ((tokens[i]).contains("rank:")) {
                    collection.filterRank(Range.parse(tokens[i]));
                    n = 1;
                }// end of rank
                if ((tokens[i]).contains("artist:")) {
                    collection.filterArtist(tokens[i]);
                    n = 1;
                }// end of artist
                if ((tokens[i]).contains("title:")) {
                    collection.filterTitle(tokens[i]);
                    n = 1;
                }// end of title
                if ((tokens[i]).contains("sort:")) {
                    if ((tokens[i]).contains("title")) {
                        collection.sortTitle();
                        n = 1;
                    }// end of sort title
                    if ((tokens[i]).contains("artist")) {
                        collection.sortArtist();
                        n = 1;
                    }// end of sort artist
                    if ((tokens[i]).contains("rank")) {
                        collection.sortRank();
                        n = 1;
                    }// end of sort rank
                    if ((tokens[i]).contains("year")) {
                        collection.sortYear();
                        n = 1;
                    }// end of sort year
                }//end of sort
            }// end of for loop

        }// end of input.hasNextline loop
        final PrintStream console = System.out; //saves original System.out
        File outputFile = new File("output.txt"); //output file
        PrintStream out = new PrintStream(new FileOutputStream(outputFile)); //new FileOutputStream
        System.setOut(out); //changes where data will be printed
        System.out.println(collection.toString());

        System.setOut(console); //changes output to print back to console
        Scanner outputFileScanner = new Scanner(outputFile); //inputs data from file
        while ((outputFileScanner.hasNextLine())) { //while the file still has data
            System.out.println(outputFileScanner.nextLine()); //print
        }
        outputFileScanner.close();
        out.close();
    }
}// end of main

class Song {

    public enum Order {

        Year, Rank, Title, Artist
    }
    public int year;
    public int rank;
    public String artist;
    public String title;

    public static Song parse(String s) {
        Song instance = new Song();
        StringTokenizer tokenizer = new StringTokenizer(s, "\t");
        instance.year = Integer.parseInt(tokenizer.nextToken());
        instance.rank = Integer.parseInt(tokenizer.nextToken());
        instance.artist = (tokenizer.nextToken());
        instance.title = (tokenizer.nextToken());
        return instance;
    }

    public int getYear() {
        return year;
    }

    public int getRank() {
        return rank;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;

    }

    public String toString() {
        String output = "\n\nYear = " + year + "\nRank = " + rank + "\nArtist = "
                + artist + "\nTitle = " + title;
        return output;
    }

}

class Range {

    private int min;
    private int max;

    public Range() {
        System.out.println("Please wait.");
    }

    public static Range parse(String s) {
        Range instance = new Range(); // instance is created here so object
        // variables may be accessed
        String field; // String to contain deleted part of user input
        StringTokenizer tokenizer = new StringTokenizer(s, "-");
        StringTokenizer tokenizer2 = new StringTokenizer(s, ":");// for separating "field:" from the
        // other part of the String
        if (s.contains(":")) { // this deletes the "field:" of the user input so
            // it does not interfere with the parsing
            field = (tokenizer2.nextToken());
            s = s.replace(field, "");
            s = s.replace(":", "");
        }
        if (s.contains("-")) {
            instance.min = Integer.parseInt(tokenizer.nextToken());
            instance.max = Integer.parseInt(tokenizer.nextToken());

        } else if (!(s.contains("-"))) {
            {
                instance.min = Integer.parseInt(s);
                instance.max = Integer.parseInt(s);
            }
        }
        System.out.println("Range max = " + instance.max);
        System.out.println("Range min = " + instance.min);
        return instance;
    }

    public boolean contains(int n) {
        if (n > min && n < max) { //if the number is contained in the range, method returns true.
            return true;
        } else if (n == min && n == max) {
            return true;
        } else {
            return false;
        }
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}

class SongCollection {

    List<Song> songs2;
    List<Song> itemsToRemove = new ArrayList<Song>(); // second collection
    // for items to
    // remove

    public SongCollection(List<Song> songs) { // constructor for SongCollection
        System.out.println("Test");
        this.songs2 = songs;
    }

    public void filterYear(Range r) {
        int n = 0;
        if (n == 0) {
            System.out.println("Program is processing.");
            n++;
            for (Song song1 : songs2) {
                if (song1.year > (r.getMax()) || (song1.year) < (r.getMin())) {
                    itemsToRemove.add(song1);
                }
            }
            songs2.removeAll(itemsToRemove);
            itemsToRemove.clear();
        }
        System.out.println(songs2);
    }

    public void filterRank(Range r) {
        int n = 0;
        if (n == 0) {
            System.out.println("Program is processing.");
            n++;
            for (Song song1 : songs2) {
                if (song1.rank > (r.getMax()) || (song1.rank) < (r.getMin())) {
                    itemsToRemove.add(song1);
                }
            }
            songs2.removeAll(itemsToRemove);
            itemsToRemove.clear();
        }
        System.out.println(songs2);
    }

    public void filterArtist(String s) {
        int n = 0;
        if (n == 0) {
            System.out.println("Program is processing.");
            n++;
            for (Song song1 : songs2) {
                if ((!(((song1.artist).contains(s))))) {
                    itemsToRemove.add(song1);
                }
            }
            songs2.removeAll(itemsToRemove);
            itemsToRemove.clear();
        }
        System.out.println(songs2);
    }

    public void filterTitle(String s) {
        int n = 0;
        if (n == 0) {
            System.out.println("Program is processing.");
            n++;
            for (Song song1 : songs2) {
                if ((!(((song1.title).contains(s))))) {
                    itemsToRemove.add(song1);
                }
            }
            songs2.removeAll(itemsToRemove);
            itemsToRemove.clear();
        }
        System.out.println(songs2);
    }

    public void sortTitle() {
        Collections.sort(songs2, SongComparator.byTitle()); // now we have a sorted list
        System.out.println(songs2);
    }

    public void sortRank() {
        Collections.sort(songs2, SongComparator.byRank()); // now we have a sorted list
        System.out.println(songs2);
    }

    public void sortArtist() {
        Collections.sort(songs2, SongComparator.byArtist()); // now we have a sorted list
        System.out.println(songs2);
    }

    public void sortYear() {
        Collections.sort(songs2, SongComparator.byYear()); // now we have a sorted list
        System.out.println(songs2);
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < songs2.size(); i++) {
            result += " " + songs2.get(i);
        }

        return result;

    }
}

class SongComparator implements Comparator<Song> {

    public enum Order {

        YEAR_SORT, RANK_SORT, ARTIST_SORT, TITLE_SORT
    }
    private Order sortingBy;

    public SongComparator(Order sortingBy) {
        this.sortingBy = sortingBy;
    }

    public static SongComparator byTitle() {
        return new SongComparator(SongComparator.Order.TITLE_SORT);
    }

    public static SongComparator byYear() {
        return new SongComparator(SongComparator.Order.YEAR_SORT);
    }

    public static SongComparator byArtist() {
        return new SongComparator(SongComparator.Order.ARTIST_SORT);
    }

    public static SongComparator byRank() {
        return new SongComparator(SongComparator.Order.RANK_SORT);
    }

    @Override
    public int compare(Song song1, Song song2) {
        switch (sortingBy) {
            case YEAR_SORT:
                return Integer.compare(song1.year, song2.year);
            case RANK_SORT:
                return Integer.compare(song1.rank, song2.rank);
            case ARTIST_SORT:
                return song1.artist.compareTo(song2.artist);
            case TITLE_SORT:
                return song1.title.compareTo(song2.title);
        }
        throw new RuntimeException(
                "Practically unreachable code, can't be thrown");
    }

}