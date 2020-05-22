List<List<String>> components = new ArrayList<List<String>>();
for( Set<String> s : treeComps )
{
  List<String> inner = new ArrayList<String>();
  inner.addAll( s );
  components.add( inner );
}