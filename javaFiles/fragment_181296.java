public class CSVFun {
  // Where to start the scan of the function.
  static final double Start = 0.0;
  // End of scan.
  static final double End = 10000.0;
  // Fine enough to detect a change in the function.
  static final double BigStep = 0.1;
  // Finest resolution.
  static final double SmallStep = 0.000000001;

  // Work out some csv for a function.
  private static void csv(F f) {
    System.out.println("Function: " + f);
    // Start at 0.
    double t = Start;
    double ft = f.f(t);
    System.out.println(t + "," + ft);
    while (t < End) {
      // Walk to the end.
      double step = BigStep;
      // Find a break point.
      while (t < End && f.f(t) == ft) {
        t += step;
      }
      if (t < End) {
        // Back one.
        t -= step;
        // Zoom in on the transition point.
        while (step > SmallStep) {
          // Go smaller.
          step /= 10;
          // Walk forward.
          while (t < End && f.f(t) == ft) {
            t += step;
          }
          // Back one.
          t -= step;
        }
        // Before
        System.out.println(t + "," + ft);
        // One more forward.
        t += step;
      }
      // Print.
      if (f.f(t) != ft) {
        ft = f.f(t);
        System.out.println(t + "," + ft);
      }
    }
  }

  // Tests the process with the sample functions below.
  public static void main(String[] args) {
    try {
      for (F f : F.values()) {
        csv(f);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  // The sample functions - Encoded in Java
  enum F {
    A {
      @Override
      double f(double t) {
        if (t < 60) {
          return (0.1);
        }
        if (t > 66.0115) {
          return (0.1);
        }
        return 1;
      }
    },
    B {
      @Override
      double f(double t) {
        if (t > 0.5) {
          return 2;
        }
        return 3;
      }
    },
    C {
      @Override
      double f(double t) {
        if (t >= 0.5) {
          return 2;
        }
        return 3;
      }
    },
    D {
      @Override
      double f(double t) {
        if (t < 0.5) {
          return 2;
        }
        return 3;
      }
    },
    E {
      @Override
      double f(double t) {
        if (t <= 0.5) {
          return 2;
        }
        return 3;
      }
    },
    F {
      @Override
      double f(double t) {
        if ((t >= 3600) & (t <= 3660)) {
          return 25;
        }
        return 0;
      }
    },;

    abstract double f(double t);
  }
}