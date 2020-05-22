public void exportDST(String dest, ArrayList<Pupil> pupils) throws IOException{
    this.pupils = pupils;
    try (DataOutputStream dot = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dest)))) {
        for (Pupil p : pupils) {
            dot.writeInt(p.getId());
            dot.writeInt(p.getNumber());
            dot.writeInt(p.getFirstname().length());
            dot.writeBytes(p.getFirstname());
            dot.writeInt(p.getLastname().length());
            dot.writeBytes(p.getLastname());
            dot.writeChar(p.getGender());
            dot.writeInt(p.getReligion().length());
            dot.writeBytes(p.getReligion());
            dot.writeInt(p.getDay());
            dot.writeInt(p.getMonth());
            dot.writeInt(p.getYear());
            dot.writeInt(p.getStreet().length());
            dot.writeBytes(p.getStreet());
            dot.writeInt(p.getPlz());
            dot.writeInt(p.getLocation().length());
            dot.writeBytes(p.getLocation());
            dot.writeInt(p.getShortName().length());
            dot.writeBytes(p.getShortName());
            dot.writeInt(p.getClassName().length());
            dot.writeBytes(p.getClassName());
            dot.writeInt(p.getKvLastname().length());
            dot.writeBytes(p.getKvLastname());
        }
    }
}