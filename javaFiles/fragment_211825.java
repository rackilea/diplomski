else {
       taxSalary = (taxSalary - taxThreshold) * higherTax + taxThreshold;
     }

     return taxSalary;  // <--- missing a return statement here
  }