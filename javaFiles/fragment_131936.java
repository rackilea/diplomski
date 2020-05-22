@JoinColumn(name = "cat_parent")
@OneToMany
Set<Category> children;
... 
public Set<Category> collectLeafChildren() { 
   Set<Category> results = new HashSet<>(); 
   if (children.isEmpty()) { 
      results.add(this); 
   } else { 
      children.forEach(child -> { 
        results.addAll(child.collectLeafChildren()); 
      }); 
   } 
   return results; 
}