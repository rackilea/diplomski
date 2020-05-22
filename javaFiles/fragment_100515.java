List<Complex> elementWiseDivision(List<Complex> dividend, List<Complex> divisor) 
{
  if (dividend.size() != divisor.size()) 
  { 
    throw new IllegalArgumentException("Must have same size"); 
  }
  List<Complex> result = new ArrayList<>();
  // using iterators to get O(n) with both LinkedList and ArrayList inputs
  for (Iterator<Complex> xit = dividend.iterator(), yit = divisor.iterator(); xit.hasNext();) 
  {
    result.add(xit.next().divide(yit.next()));
  }
  return result;
}