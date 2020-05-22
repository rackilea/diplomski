for(int j = 1; j <= adjLists.size(); j++){      //get adjacency lists
    for(int a=1; a <=edgeA.size(); a++){
        if(edgeA.get(a)==j){ (adjLists.get(j)).add(edgeB.get(a));}
        if(edgeB.get(a)==j){ (adjLists.get(j)).add(edgeA.get(a));}
    }
}