MaskFormatter latitudeformat=new MaskFormatter("##.######");
MaskFormatter longitudeformat=new MaskFormatter("###.######");
latitudeformat.setPlaceholderCharacter('0');
latitudeformat.setOverwriteMode(true);
longitudeformat.setPlaceholderCharacter('0');
longitudeformat.setOverwriteMode(true);    

JFormattedTextField latitudeField = new JFormattedTextField(latitudeformat);
JFormattedTextField longituteField = new JFormattedTextField(longitudeformat);