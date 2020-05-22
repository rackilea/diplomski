for (int i = 0; i < data.size(); i++) {
    marksReads[i] = new MarksReads();
    marksReads[i].setDescription(data(i).get("description"));
    marksReads[i].setMark(Integer.valueOf(data.get(i).get("mark")));
    marksReads[i].setType(Integer.valueOf(data.get(i).get("type")));
 }