if(arr != null){
            for (int i = 1; i < arr.size(); i++) {
           ArrayList<String> oneRow = new ArrayList();
            oneRow.add(arr.get(i));
                for (int j = 0; j < oneRow.size(); j++) {
                    strBuild.append(oneRow.get(j));
                }
    }
    System.out.println(strBuild.toString());
}