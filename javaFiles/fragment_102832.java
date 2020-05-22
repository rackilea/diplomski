class SaveFile implements ActionListener {
        private string completeName;

        public void uploadToDatabase(String compName){
             //code...
             this.completeName = compName;
        }

        public void actionPerformed(ActionEvent e) {    
            System.out.println(completeName);
        }
   }
}