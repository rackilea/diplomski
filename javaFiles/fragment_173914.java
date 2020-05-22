String trunk = "50 | 1 | 13";
        String temp = trunk.replaceAll("\\s+","");
        String[] dial_discagem = temp.split("\\|");
        String dial = "";
        String[] innerData = new String[dial_discagem.length];
        for(int i=0;i<dial_discagem.length;i++){

          innerData[i] = dial_discagem[i];
          String id = innerData[i];
          dial += getDialDiscagem(Integer.parseInt(id))+"|";
        }