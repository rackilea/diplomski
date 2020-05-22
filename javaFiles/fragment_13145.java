while ((line = user.readLine()) != null) {
    if (line.toLowerCase().contains(nume.toLowerCase())) {
        System.out.println("Ce mai faci " + nume + "?");
        ceva = scanIn.nextLine(); 
        break;  // exists the closest loop
    }
}