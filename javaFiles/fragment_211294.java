public int getBoardSize() {
        int buttonCount = 0;
        TableLayout tableLayout = (TableLayout) findViewById(R.id.tableLayout);
        for(int rowIndex=0; rowIndex<tableLayout.getChildCount(); rowIndex++){
            View tableLayoutChild = tableLayout.getChildAt(rowIndex);
            if(tableLayoutChild instanceof TableRow){
                for (int i = 0; i < ((ViewGroup)tableLayoutChild).getChildCount(); i++) {
                    System.out.println("Value of button child i: " + i);
                    View view = ((ViewGroup)tableLayoutChild).getChildAt(i);
                    if (view instanceof Button && view.getId() == R.id.gridButton1 ) {
                        buttonCount++;
                    }
                }
            }
        }


        System.out.println("Child count: " + buttonCount);
        return buttonCount;
    }