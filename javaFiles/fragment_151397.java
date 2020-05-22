class Tree {
   String name
   Level rootLevel

   static hasMany = [levels: Level]
   static mappedBy = [rootLevel: "parentTree", levels: "owningTree"]

   static constraints = {rootLevel(nullable: true)}
}