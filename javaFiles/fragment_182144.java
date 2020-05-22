public class MyRenderer ....
    JProgressBar determinate;
    JProgressBar indeterminate; 

    public Component getTableCellRendererComponent(...) {
         if (value.isDeterminate) {
           ...
           return determinate;
         }
         ....
         return undeterminate
    }