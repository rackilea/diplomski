public static void main (String[]args) throws Exception {
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            File file = UI.selectFile();
            if (file == null) {
                System.out.println("No file selected");
            }

            FileInputStream fis= new FileInputStream (file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet1= wb.getSheetAt(0);
        }
    });