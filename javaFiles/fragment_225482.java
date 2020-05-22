try {
            Integer.parseInt(textField.getText());
            //Some operations
        } catch (NumberFormatException e) {
            //Here for example prompt some window notifying user
            System.out.println(e);
        }