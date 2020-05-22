// No need to create new instances of String...
//  if (this.recChangedBy == null)
//      destination.recChangedBy = null;
//  else
//      destination.recChangedBy = this.recChangedBy.substring(0);

// so above is replaced by:
destination.recChangedBy = this.recChangedBy;