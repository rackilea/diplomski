public class WHN implements Comparable<WHN>{
        private HierarchNode node;
        private float weight;

        public HierarchNode getNode() {return node;}
        public float getWeight() {return weight;}

        public WHN(HierarchNode node, float weight) {this.node = node;this.weight = weight;}

        public int compareTo(WHN o) {return Float.compare(this.weight, o.weight); }
    }

    Map<Tag,<SortedMap<Float,HierarchNode>> map = new HashMap<Tag,List<WHN>> 
    for (HierarchNode n : cluster){
    for (Map.Entry tw : n.tags.entrySet()){
        Tag tag = tw.getKey();
        Float weight = tw.getValue();
        if (!map.ContainsKey(tag)){
            map.put(tag,new ArrayList<WHN>();
        }
        map.get(tag).add(new WHN(n,weight));
    }
    for(List<WHN> l: map.values()){
        Collections.Sort(l);
    }
}