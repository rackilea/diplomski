while (left.size()>0 && right.size()>0) { // iteration on left/right lists
      if (left.get(0).compareTo(right.get(0)) < 0) {
        out.add(left.remove(0)); // modification of the left list
      } else {
        out.add(right.remove(0)); // modification of the right list
      }
 }