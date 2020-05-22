for (String humanStr : file.split("#", 0)) {
    String[] h = humanStr.split("\n", 0);

    madeHumanArrayList.add(new Human(h[0], Integer.parseInt(h[1]), 
                                     Float.parseFloat(h[2]), Float.parseFloat(h[3])));
}