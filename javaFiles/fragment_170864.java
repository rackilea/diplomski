String name = lblCompanyName.getText();
        String address = lblAddress.getText();

        try {
            PrinterJob job = PrinterJob.getPrinterJob();

            MessageFormat[] header = new MessageFormat[3];

            header[0] = new MessageFormat("line 1");
            header[1] = new MessageFormat("                    " + name);
            header[2] = new MessageFormat("                  " + address);

            MessageFormat[] footer = new MessageFormat[2];
            footer[0] = new MessageFormat("");
            footer[1] = new MessageFormat("-{1}-");
            job.setPrintable(new MyTablePrintable(table, JTable.PrintMode.FIT_WIDTH, header, footer));
            job.printDialog();
            job.print();

        } catch (Exception ex) {
        }