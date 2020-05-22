public void save() {
    try {
        if (!file.exists()) {
            try {
                file.createNewFile();
                pwriter.print(area.getText());
                System.out.println(area.getText());
                System.out.println("Saved complete");

            } catch (Exception ef) {
                ef.printStackTrace();
                System.err.print("Cannot Create");
            }

        } else if (file.exists()) {
            pwriter.print(area.getText());
            System.out.println(area.getText());
            System.out.println("Overwrite complete");
        }
    } catch (Exception exp) {
        exp.printStackTrace();
        System.err.println("Cannot Save");
    } finally {
        pwriter.flush();
    }
}