public static <P extends Point>  PointCloud<P> combine(ArrayList<PointCloud<P>> pcList) { 
    PointCloud<P> combinated_pc = new PointCloud<>(); 
    for(PointCloud<P> pc: pcList) { 
        combinated_pc.addPoints(pc.getPoints()); 
    } 
    return combinated_pc;
}