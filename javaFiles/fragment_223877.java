Scanner in = new Scanner(System.in);
    ArrayList<String> auto = new ArrayList<>();
    ArrayList<String> unsortedAutos = new ArrayList<>();
    boolean done = false;
    do {
        String autoList = JOptionPane.showInputDialog(null, "Enter an Auto you like (q to finish):",
                "click OK for each auto entry");
        if (autoList.equalsIgnoreCase("q")) {
            break;
        }
        auto.add(autoList);
    } while (!done);


    unsortedAutos = (ArrayList<String>) auto.clone();
    Collections.sort(auto);

    System.out.println("auto: "+ unsortedAutos);
    System.out.println("auto: "+ auto);

    JOptionPane.showMessageDialog(null, "Arra list " + unsortedAutos
            + "\n Sorted list is " + auto);
    // should print straight user's input on one line and sorted Array list on the second line
    in.close();