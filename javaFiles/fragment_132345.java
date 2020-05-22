while ((line = br.readLine()) != null) {

            // get the name and the address of this line
            String nameMark = "#n";
            String addressMark = "#a";

            int nameStart = line.indexOf(nameMark) + nameMark.length();
            int addressStart = line.indexOf(addressMark) + addressMark.length();

            String name = line.substring(nameStart, addressStart - addressMark.length());
            String address = line.substring(addressStart, line.length());

            // get the line type
            if (line.startsWith("tipo1")) {
                    //code that creates file type1 with name and address
            }
            else if(line.startsWith("tipo2")) {
                    //code that creates file type2 with name and address
            }
    ...
    ...
        }