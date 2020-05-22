for(String line : lines){
      String[] vals = line.split(";");
      UniversityScore score = new UniversityScore(vals[0],vals[1],Double.parseDouble(vals[2]),Integer.parseInt(vals[3]))
      if(scores.containsKey(score.getYear()){ // If the key exists
         scores.get(score.getYear()).add(score);
      }else{ // If the key doesn't exist, it must be created and added to the map
         ArrayList<UniversityScore> newList = new ArrayList<>();
         newList.add(score);
         scores.put(score.getYear(), newList)
      }
    }