if(contains(ticketNum,sc.nextInt())){
    throw new DuplicateValueException();
}
if((sc.nextInt()<1)||(sc.nextInt()>90)){
    throw new ValueException();
}