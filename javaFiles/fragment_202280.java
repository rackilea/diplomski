public interface I {
  Dummy getDummy(); // this can only be used and implemented inside of the 
                    // current package, because Dummy is package private
  String methodToUseOutsideOfPackage();
}

interface Dummy {}