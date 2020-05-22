for(int i=0;i < input.size(); i++) {
    System.out.println("For Row " + i + " of file:");    
    InputNode[] = input.get(i);
    for (int j=0;j < InputNode.length; j++ ) {
       System.out.println("   InputNode[ " + j + "] = " + InputNode[j].output());
    } 
}