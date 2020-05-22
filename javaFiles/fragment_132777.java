package windows;

import java.io.File;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

 /** Get the progress of Vacuum Operation */
public class VacuumProgress extends Service<Void> {

File basicFile;
File journalFile;

/**
 * Starts the Vacuum Progress Service
 * 
 * @param basicFile
 * @param journalFile
 */
public void start(File basicFile, File journalFile) {
    this.basicFile = basicFile;
    this.journalFile = journalFile;
    reset();
    start();
}

@Override
protected Task<Void> createTask() {
    return new Task<Void>() {
        @Override
        protected Void call() throws Exception {

            System.out.println("Started...");

            long bfL = basicFile.length();
            while (!journalFile.exists()) {
                Thread.sleep(50);
                System.out.println("Journal File not yet Created!");
            }
            long jfL = journalFile.length();

            while (jfL <= bfL) {
                updateProgress(jfL = journalFile.length(), bfL);
                Thread.sleep(50);
            }

            System.out.println("Exited Vacuum Progress Service");
            return null;
        }

    };
}

}