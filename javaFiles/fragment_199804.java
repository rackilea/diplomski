package File_Conversion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.control.ProgressIndicator;

/**
 * This class is the background 'worker' thread that does all of the heavy duty
 * file IO for splitting up the NC file. It periodically sends reports back to
 * the main application thread to update the progress indicator.
 *
 * @author William
 */
public class DateWriter implements Runnable {

    private final ProgressIndicator myIndicator;
    private static File ncFile;
    private final String outputLocationFile;
    private float zmax, zmin, xmax, xmin, ymax, ymin;
    private ArrayList<Float> xList, yList, zList;
    private final DecimalFormat numberFormat = new DecimalFormat("#.000000");
    private final DecimalFormat numberFormatMinMax = new DecimalFormat("#.00000");
    private final boolean yr_mon_day;

    /**
     * This is the main constructor, it needs a valid NC file to continue.
     *
     * @param inputNCFile
     * @param outputLocation
     * @param myIndicator
     * @param yr_mon_day
     */
    public DateWriter(String inputNCFile, String outputLocation, ProgressIndicator myIndicator, boolean yr_mon_day) {
        this.yr_mon_day = yr_mon_day;
        this.myIndicator = myIndicator;
        ncFile = new File(inputNCFile);
        outputLocationFile = outputLocation;
    }

    /**
     * The primary run() method, starts the thread.
     */
    @Override
    public void run() {
        convertDate();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                File_Conversion.stage_returner().close();
            }
        });
        System.out.println("At the end of the method.");

    }

    public boolean convertDate() {

        BufferedReader br = null;
        java.io.FileWriter yearWriter = null, monthWriter = null, dayWriter = null, fWriter = null;
        BufferedWriter yearBuf = null, monthBuf = null, dayBuf = null, writer = null;
        try {
            br = new BufferedReader(new FileReader(ncFile));
            if (yr_mon_day) {
                yearWriter = new java.io.FileWriter(outputLocationFile + "\\" + ncFile.getName().substring(0, ncFile.getName().lastIndexOf(".")) + "_modified_year.csv", false);
                yearBuf = new BufferedWriter(yearWriter);
                monthWriter = new java.io.FileWriter(outputLocationFile + "\\" + ncFile.getName().substring(0, ncFile.getName().lastIndexOf(".")) + "_modified_month.csv", false);
                monthBuf = new BufferedWriter(monthWriter);
                dayWriter = new java.io.FileWriter(outputLocationFile + "\\" + ncFile.getName().substring(0, ncFile.getName().lastIndexOf(".")) + "_modified_day.csv", false);

                dayBuf = new BufferedWriter(dayWriter);
                String input;
                String temp;
                String temp2;
                String temp3;
                while ((input = br.readLine()) != null) {
                    temp = input.substring(0, 4);

                    temp2 = input.substring(4, 6);

                    temp3 = input.substring(6);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            myIndicator.setProgress(-1);
                        }
                    });
                    yearBuf.write(temp + "\n");
                    monthBuf.write(temp2 + "\n");
                    dayBuf.write(temp3 + "\n");
                    yearBuf.flush();
                    monthBuf.flush();
                    dayBuf.flush();
                    temp = null;
                    temp2 = null;
                    temp3 = null;

                }
            } else {
                fWriter = new java.io.FileWriter(outputLocationFile + "\\" + ncFile.getName() + "_modified.csv", false);
                writer = new BufferedWriter(fWriter);
                String input;
                String temp;
                while ((input = br.readLine()) != null) {
                    temp = input.substring(0, 4) + "," + input.substring(4, 6) + "," + input.substring(6);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            myIndicator.setProgress(-1);
                        }
                    });
                    writer.write(temp + "\n");
                    writer.flush();

                }

            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (yearBuf != null) {
                    yearBuf.close();
                }
                if (monthBuf != null) {
                    monthBuf.close();
                }
                if (dayBuf != null) {
                    dayBuf.close();
                }
                if (yearWriter != null) {
                    yearWriter.close();
                }
                if (monthWriter != null) {
                    monthWriter.close();
                }
                if (dayWriter != null) {
                    dayWriter.close();
                }
                if (fWriter != null) {
                    fWriter.close();
                }
                if (writer != null) {
                    writer.close();
                }

            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
        return true;
    }

}