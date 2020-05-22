public Student worstStudentRec(Node list)
  {
    if (list == null)
      return null;  // add null-handling
    else if (list.next == null)
        return list.data;

    Node theWorstFromOthers = worstStudentRec(list.next);
    return (list.data.compareTo(theWorstFromOthers.data) <= 0) ? list.data : theWorstFromOthers.data;
  }