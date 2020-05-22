while(total >= 0) {
    if(total >= oNum) { 
        newBase.add(total - oNum);
        total -= oNum;
        System.out.println(total);
    }
    else {
        newBase.add(total);
    }
}