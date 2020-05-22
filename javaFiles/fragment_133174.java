public class truthtable2 {
  public ArrayList<Variables[]> bits  = new ArrayList<>();

  public truthtable2(ArrayList <String> inputs){       
    String [] inputsTab = inputs.toArray(new String[inputs.size()]);
    int total = (int) (Math.pow(2,inputs.size()))-1;
    String tab[]=new String[total+1];
    for(int i =0;i<=total;i++){
      // changed the below line
      tab[i]=(String.format("%"+inputs.size()+"s", Integer.toBinaryString(i)).replace(' ', '0'));
      System.out.println(tab[i]);
    }
    for(int i = 0;i<tab.length;i++){
      char[] chars = tab[i].toCharArray();

      Variables[] bittab = new Variables[inputsTab.length]; // Moved this here
      for(int x = 0;x<inputs.size();x++){
        // Changed this to use variable size
        int d = inputs.size()-x-1;
        bittab[x]= new Variables(chars[d], inputsTab[x]);           
      }
      bits.add(bittab);  
    }
    for(Variables[] d: bits){
      for(int f = 0;f<d.length;f++){
        System.out.format("%4s %4s \n",d[f].bit,d[f].name);
      }
    }
  }

  public class Variables {
    boolean bit;
    String name;
    public Variables(int b, String name){
      this.name = name;
      bit = test(b);
    }
    // Totally rewrote function
    public boolean test(int b) {
      System.out.println(b);
      return b==49;
    }
  }
}