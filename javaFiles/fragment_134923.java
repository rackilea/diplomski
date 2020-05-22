if (foundFirst && foundSecond) {

    if (second == this.tail) {
      this.tail = first;
    } else if (first == this.tail) {
      this.tail = second;
    }

    if (first == this.head) {
      this.head = second;
    } else if (second == this.head) {
      this.head = first;
    }

    if (firstPrev == second) {
      first.next = second;
    } else {
      if (firstPrev != null) {
        firstPrev.next = second;
      }
      first.next = secondNext;
    }
    if (secondPrev == first) {
      second.next = first;
    } else {
      if (secondPrev != first && secondPrev != null) {
        secondPrev.next = first;
      }
      second.next = firstNext;
    }
    break;
  }