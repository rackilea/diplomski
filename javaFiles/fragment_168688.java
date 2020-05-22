boolean same = true;
while(iterator.hasNext()){
  if(!desIterator.hasNext() || !iterator.next().equals(desIterator.next())){
    same = false;
    break;
  }
}

System.out.println(same);