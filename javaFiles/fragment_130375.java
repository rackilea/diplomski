// File: arrays/filelist/Filelistsort.java
// Purpose: List contents of user home directory.
//          Demonstrates use of Comparators to sort the
//          same array by two different criteria.
// Author: Fred Swartz 2006-Aug-23  Public domain.

import java.util.Arrays;
import java.util.Comparator;
import java.io.*;

public class Filelistsort {

    //======================================================= main
    public static void main(String[] args) {
        //... Create comparators for sorting.
        Comparator<File> byDirThenAlpha = new DirAlphaComparator();
        Comparator<File> byNameLength   = new NameLengthComparator();

        //... Create a File object for user directory.
        File dir = new File(System.getProperty("user.home"));
        File[] children = dir.listFiles();

        System.out.println("Files by directory, then alphabetical");
        Arrays.sort(children, byDirThenAlpha);
        printFileNames(children);

        System.out.println("Files by length of name (long first)");
        Arrays.sort(children, byNameLength);
        printFileNames(children);
    }

    //============================================= printFileNames
    private static void printFileNames(File[] fa){
        for (File oneEntry : fa) {
            System.out.println("   " + oneEntry.getName());
        }
    }
}


////////////////////////////////////////////////// DirAlphaComparator
// To sort directories before files, then alphabetically.
class DirAlphaComparator implements Comparator<File> {

    // Comparator interface requires defining compare method.
    public int compare(File filea, File fileb) {
        //... Sort directories before files,
        //    otherwise alphabetical ignoring case.
        if (filea.isDirectory() && !fileb.isDirectory()) {
            return -1;

        } else if (!filea.isDirectory() && fileb.isDirectory()) {
            return 1;

        } else {
            return filea.getName().compareToIgnoreCase(fileb.getName());
        }
    }
}


////////////////////////////////////////////////// NameLengthComparator
// To sort by length of file/directory name (longest first).
class NameLengthComparator implements Comparator<File> {

    // Comparator interface requires defining compare method.
    public int compare(File filea, File fileb) {
        int comp = fileb.getName().length() - filea.getName().length();
        if (comp != 0) {
            //... If different lengths, we're done.
            return comp;
        } else {
            //... If equal lengths, sort alphabetically.
            return filea.getName().compareToIgnoreCase(fileb.getName());
        }
    }
}