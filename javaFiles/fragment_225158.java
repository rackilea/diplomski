timer = new Timer(100, new ActionListener() {
     public void actionPerformed(ActionEvent e) {
          String line;
           try {
                if ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                } else {
                   ((Timer) e.getSource()).stop();
                }
           } catch (IOException ex) {
                Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
           }
     }
});