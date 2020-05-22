ArrayList<Supplier> a = new ArrayList<>();

 String[] choices = a.toArray();

  String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
    "Choose supplier of the product !!", JOptionPane.QUESTION_MESSAGE, null,                                                                     
    choices, // Array of choices
    choices[1]); // Initial choice