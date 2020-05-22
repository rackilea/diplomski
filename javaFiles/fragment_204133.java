public static void main(String [] args) {
        List<String> output = new ArrayList<>();
        output.add("body/div[2]/div[3]/div/div[1]/div/div[2]/div[2]/ul/li[8]/div/div/div/div[2]/div[2]/div/span[2]");
        output.add("body/div[2]/div[3]/div/div[1]/div/div[2]/div[2]/ul/li[8]/div/div/div/div[2]/div[2]/a/h2");
        output.add("body/div[2]/div[3]/div/div[1]/div/div[2]/div[2]/ul/li[8]/div/div/div/div[2]/div[3]/div[1]/div[2]/a/span");
        output.add("body/div[2]/div[3]/div/div[1]/div/div[2]/div[2]/ul/li[8]/div/div/div/div[2]/div[3]/div[1]/div[4]/div[2]/a/span[1]");
        output.add("body/div[2]/div[3]/div/div[1]/div/div[2]/div[2]/ul/li[9]/div/div/div/div[2]/div[3]/div[1]/div[8]/a/span");
        output.add("body/div[2]/div[3]/div/div[2]/div/div[2]/div/div/ul[4]/li[4]/a/span[1]");
        List<String> hh = findCommonSubstring(output);
        for(String filteredOutput: hh)
            System.out.println(filteredOutput);

    }

    private static List<String> findCommonSubstring(List<String> output) {
        List<String> hh = new ArrayList<String>();
        for(int a=0; a<output.size(); a++)
        {
            for(int b=0; b<output.size(); b++) {
                String chemin = output.get(a);
                if(a != b)
                {
                    String chemin_compare = output.get(b);
                    while(true) {
                        if(chemin_compare.indexOf(chemin) != -1 && !output.contains(chemin))
                            hh.add(chemin);
                        if(chemin.contains("/")) {
                            chemin = chemin.substring(0, chemin.lastIndexOf("/"));
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        final ArrayList<String> filteredOutputList = new ArrayList<>();
        for (String string1 : hh) {
            boolean stringIsContainedInOtherString = false;
            for (String string2 : hh) {
                if(!string2.equals(string1) && string2.contains(string1)) {
                        stringIsContainedInOtherString = true;
                        break;
                }
            }
            if(!stringIsContainedInOtherString && !filteredOutputList.contains(string1)) {
                filteredOutputList.add(string1);
            }
        }

        if (filteredOutputList.size()>1)
            return findCommonSubstring(filteredOutputList);
        return filteredOutputList;
    }