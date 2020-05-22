final JTable table = new JTable(myModel){

        /** 
         * @inherited <p>
         */
        @Override
        public Printable getPrintable(PrintMode printMode,
                MessageFormat headerFormat, MessageFormat footerFormat) {
            Printable printable = super.getPrintable(printMode, null, null);
            CustomTablePrintable custom = new CustomTablePrintable(headerFormat, footerFormat);
            custom.setTablePrintable(this, printable);
            return custom;
        }

    };