char array[]=input.toCharArray();
Set<Character> m=new LinkedHashSet<Character>();
for(int i=0;i<array.length;i++){
   if(array[i]!=' ')
      m.add(array[i])
}
Character[] text = m.toArray(new Character[0]);
System.out.println(Arrays.toString(text))