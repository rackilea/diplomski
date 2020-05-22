OUTER: for (x : xList) {
          for (y : yList) {
              // Do something, then:
              if (x > y) {
                  // This goes to the next iteration of x, whereas a standard
                  // "continue" would go to the next iteration of y
                  continue OUTER;
              }
          }
       }