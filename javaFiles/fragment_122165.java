final JLabel label;
class MeaningOfLifeFinder extends SwingWorker<String, Object> {
   @Override
   public String doInBackground() {
       return findTheMeaningOfLife();
   }

   @Override
   protected void done() {
       try { 
           label.setText(get());
       } catch (Exception ignore) {
       }
   }
}

(new MeaningOfLifeFinder()).execute();