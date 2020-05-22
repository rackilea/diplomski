// Your code
List<String> st=new ArrayList<String>();
st.add("Massachusetts institute "); 
st.add("of ");
st.add("Technology ");
st.add("MIT");
/* Added a few more to st for my own tests - see IDEONE link below */
//-------------------------------------------------------------------

/* Additional code */
Set<String> combs = new HashSet<String>(); // Set of matches default 16 spaces
/* The code should work even if the size goes above 16 - tried it in IDEONE */

int p = st.size(); // Get the endpoint

for(int i =0; i<p; i++){
     for(int j=i+1; j<p; j++) {
         combs.add(st.get(i) + st.get(j));
    }
}
Iterator g = combs.iterator();

while(g.hasNext()) {
    System.out.println(g.next());
}
}
/************************************************/