Table table = new Table( 2 ); // 2 is the number of columns

table.setWidth( 100 );
table.setDefaultVerticalAlignment( Element.ALIGN_TOP ) ;
table.setCellsFitPage( true );
table.setPadding( 2 );
table.setSpacing( 0 );

for ( int i = 1 ; i <= 3 ; i++ )
{
     Cell leftCell = new Cell( i );
     Cell rightCell = new Cell( "Data " + i );

     table.addCell( leftCell );
     table.addCell( rightCell );
}