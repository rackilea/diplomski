public void print() {
    for (InsuranceInfo element: container) {
       if (element.getValue() > 100) { // Here is your condition to filter elements
          // Process your elements here
       }
    }
}