if ("choiceReroll".equals(area)) {
           System.out.println("choiceReroll equals area");
           if (e.getSource() == textYes) {
              System.out.println("source is textYes");
              rerollChoice("yes");
           }
           if (e.getSource() == textNo) {
              rerollChoice("no");
           }
        }