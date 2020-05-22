private void prepareListData() {
            listDataHeader = new ArrayList<String>();
            listDataChild = new HashMap<String, List<String>>();
            databaseProjects = new ArrayList<>();
            int countheaders = 0;


            for(int i = 0; i < databasePositions.size(); i++) {


                if (!(databasePositions.get(i).equals("None"))) {
                    arrayListTagNames=new ArrayList<String>();

                    listDataHeader.add(databasePositions.get(i));

                    databaseProjects = databaseAdapter.getAllProjectsNameOnlyDBusingserverID(databasePositionsid.get(i));

                    for (int j = 0; j < databaseProjects.size(); j++) {
                        if (!(databaseProjects.get(j).equals("None"))) {
                            arrayListTagNames.add( databaseProjects.get(j));
                        }
                    }

                    listDataChild.put(listDataHeader.get(countheaders), arrayListTagNames);


                    countheaders++;
                }
            }
        }