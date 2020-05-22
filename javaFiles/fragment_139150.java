. . .
while (reader.hasNext()) {
    s = reader.nextLine();
    Scanner line = new Scanner(s);
    String cmd;

    if (!s.trim().isEmpty()) {
        if (p == null) {
            // starting a new block -- create a new patient record
            p = new Patient();
            recordList.add(p);
        }

        if (cmd.equalsIgnoreCase("name")) {
            index++;
            p.setName(line.nextLine());
            addressActive = false;
            mhActive = false;
        } else if (cmd.equalsIgnoreCase("address")) {
            if (line.hasNext()) {
                p.setAddress(line.nextLine().trim());
            }
            addressActive = true;
            mhActive = false;

        } else if (cmd.equalsIgnoreCase("birthday")) {
            p.setBirthday(line.nextLine());
            addressActive = mhActive = false;
        } else if (cmd.equalsIgnoreCase("email")) {
            if (line.hasNext()) {
                p.setEmail(line.nextLine());
            }
            addressActive = mhActive = false;
        } else if (cmd.equalsIgnoreCase("phone")) {
            if (line.hasNextInt()) {
                p.setPhone(line.nextInt());
            }
            addressActive = mhActive = false;
        } else if (cmd.equalsIgnoreCase("medicalHistory")) {
            mh = new MedicalHistory();
            //...parse the medicalHistory
            addressActive = false;
            mhActive = true;
        } else if (addressActive) {
            String address = p.getAddress() + " " + s.trim();
            p.setAddress(address);
        } else if (mhActive) {
            //to deal with multiple medical histories
        } else
            System.out.println("Error: no command:" + s);
        }
    } else {
        // blank line indicates end of block
        p = null;
    }
}
. . .