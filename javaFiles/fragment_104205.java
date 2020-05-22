while(it.hasNext()){
    String iteratorValue = (String)it.next();
    area1.append(iteratorValue + "\n");
    Qnum = Integer.parseInt(iteratorValue);
    System.out.println("queue next value: "+Qnum);
}