List<String> optionList = new ArrayList<String>();
optionList.add("Ham");
optionList.add("Eggs");
optionList.add("Bacon");
Object[] options = optionList.toArray();
Object value = JOptionPane.showInputDialog(null, 
                                           "Favorite Food", 
                                           "Food", 
                                            JOptionPane.QUESTION_MESSAGE, 
                                            null,
                                            options, 
                                            options[0]);

int index = optionList.indexOf(value);