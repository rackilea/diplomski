public void setRolloverBorders( boolean rollover ) {
        rolloverBorders = rollover;

        if ( rolloverBorders )  {
            installRolloverBorders( toolBar );
        } else  {
            installNonRolloverBorders( toolBar );
        }
    }