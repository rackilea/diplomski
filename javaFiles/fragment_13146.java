boolean stop = false;
while (!stop && (line = user.readLine()) != null) {
    if (line.toLowerCase().contains(nume.toLowerCase())) {
        System.out.println("Ce mai faci " + nume + "?");
        ceva = scanIn.nextLine();
        stop = true;
    }
}