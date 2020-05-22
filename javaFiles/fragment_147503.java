/* .table-row-cell */

.table-row-cell:disabled{
    -fx-opacity:0.5;
}

.table-row-cell .text{
    -fx-font-weight:bold;
    -fx-fill: black ;
} 

.table-row-cell:focused .text {
     -fx-fill: white ;
}

.table-row-cell:focused{
    -fx-background-color:purple;
}

.table-row-cell:focused:disabled{ /* focused+disabled */
    -fx-background-color:blue;
}

.table-row-cell:hover{
    -fx-background-color:magenta;
}