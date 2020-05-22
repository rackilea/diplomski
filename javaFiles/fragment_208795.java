package com.pierreantoineguillaume;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.apache.pdfbox.printing.PDFPrintable;
import org.apache.pdfbox.printing.Scaling;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

public class BasicPrinter {

    public static void main(String[] args) {
        BasicPrinter basicPrinter = new BasicPrinter();
        String printerName = "name of my printer";
        String filename = "my file to print";

        try {
            Optional<PrintService> printService = basicPrinter.getMatchingPrintService(printerName);
            basicPrinter.printA4(printService.get(), PDDocument.load(new File(filename)));
        } catch (NoSuchElementException e) {
            System.err.println("Could not locate printer " + printerName);
        } catch (PrinterException e) {
            System.err.println("Could not print file because some error occurred during the print job or a compatibility error with the service");
        } catch (IOException e) {
            System.err.println("Could not find file to print");
        }
    }

    public void printA4(PrintService printer, PDDocument documentToPrint) throws PrinterException {

        PrinterJob job = PrinterJob.getPrinterJob();

        job.setPageable(new PDFPageable(documentToPrint));
        job.setPrintable(new PDFPrintable(documentToPrint, Scaling.SCALE_TO_FIT));


        job.setPrintService(printer);
        job.print(getA4Attributes());
    }

    public Optional<PrintService> getMatchingPrintService(String printerName) {
        for (PrintService i : PrintServiceLookup.lookupPrintServices(null, getA4Attributes())) {
            if (i.getName().equals(printerName)) {
                return Optional.of(i);
            }
        }

        return Optional.empty();
    }

    private PrintRequestAttributeSet getA4Attributes() {
        PrintRequestAttributeSet attr_set = new HashPrintRequestAttributeSet();
        attr_set.add(MediaSizeName.ISO_A4);
        return attr_set;
    }
}