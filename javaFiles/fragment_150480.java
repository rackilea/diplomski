List<String> countriesList = new ArrayList<>(
Arrays.asList("Japan", "Sverige", "Tyskland", "Spanien", "Syrien", "Litauen"));

String addland = JOptionPane.showInputDialog("Vilket land vill du lägga till?").trim();
countriesList.set(5,addland);
System.out.println(countriesList);