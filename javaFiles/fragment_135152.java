if (Math.abs(result) < 1e-10) {
      System.out.println(mid);
      solved = true;
} else if (result > 0) {
      upperBound = mid;
} else if (result < 0) {
      lowerBound = mid;
}