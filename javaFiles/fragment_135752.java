private static void saveFile(ArrayList<Vehicle> vehs){
    File fileName = new File("VehicleList.txt"); 


    try {
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter output = new BufferedWriter(fw);

        for (int i = 0; i < vehs.size(); i++){
            output.write(vehs.get(i).toString());
            output.newLine();
        }

        output.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "I cannot create that file");
    }
}