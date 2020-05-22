public String toString()
  {
  String printPerimeter = "The perimiter is " + perimeter;
  String printArea = "The area is " + area;

  return printPerimeter; <-- This will be returned

  return printArea; <-- Program control will never reach here 
and hence you are getting the error "unreachable code"

 }