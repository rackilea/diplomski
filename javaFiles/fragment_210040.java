btn.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            FileOutputStream out = new FileOutputStream(new File("schedule.xlsx"));                 
            writeInfoToCell(firstCell,50);
            System.out.println(firstCell.getRawValue());
            schedule.write(out);
            out.close();
            }

        });