public boolean equals(Object obj)
{
    if(!(obj instanceof Golfer)) return false;

    Golfer golfer = (Golfer)obj;
    String thisString = score + ":" +  name;  
    String otherString = golfer.getScore() + ":" + golfer.getName() ;
    System.out.println("Golfer.equals() has bee called");

    return thisString.equalsIgnoreCase(otherString);
}