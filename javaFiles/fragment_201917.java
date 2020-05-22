Collections.sort(masterList, myComparator);
Collections.sort(updatedIDs);

Iterator m_it = masterList.iterator();
Iterator u_it = updatedIDs.iterator();

// * Some code here to deal with the possibility that either list is empty

Record rec    = m_it.next();
int    u      = u_it.next();
bool   done   = false;

while (! done) {
  if (rec.getID() < u) {
    // rec's ID was missing from updatedIDs
    m_it.remove();

    if (m_it.hasNext()) {
      rec = m_it.next();
    } else {
      done = true;
      // * add u and all subsequent updated IDs to master list
    }
  } else if (rec.getID() > u) {
    // u is new - doesn't occur in masterList
    // * add u to masterList (or probably to a separate list that you
    //   later append to masterList)

    if (u_it.hasNext()) {
      u = u_it.next();
    } else {
      done = true;
      // * remove rec and all remaining records from the master list
    }
  } else {
    // rec's ID matches u: proceed to next pair of items
    bool m_nx = m_it.hasNext(), u_nx = u_it.hasNext();
    if (m_nx && u_nx) {
      rec = m_it.next();
      u = u_it.next();
    } else if ((! m_nx) && (! u_nx)) {
      done = true;
    } else if (m_nx && (! u_nx)) {
      done = true;
      // * remove all subsequent records from the master list
    } else if ((! m_nx) && u_nx) {
      done = true;
      // * add all subsequent integers in updatedIDs to the master list
    }
  }
}