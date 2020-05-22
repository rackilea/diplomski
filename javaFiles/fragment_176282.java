// ideally you should also check (n!=null && m!=null) 
  // it handles the case where there is no common point
  while(n!=null && m!=null && n.next == m.next){
     n = n.next;
     m = m.next;
 }
 return (n == null || m == null)? null : n;