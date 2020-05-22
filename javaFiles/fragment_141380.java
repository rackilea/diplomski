while (list.getSize() > 0){
        ItemInfo item = list.removeFront();
        System.out.println( "Condition Name " + item.getCondName() );
        System.out.println( "\t Empy Can Test: " + item.getEmptyCanTest() );
        System.out.println( "\t Speed's Test: " + item.getSpeedsTest() );
        System.out.println( "\t Apprehension Test: " + item.getApprehensionTest() );
        System.out.println( "\t Pain Provocation Test: " + item.getpainProvocationTest() );
        System.out.println();
    }