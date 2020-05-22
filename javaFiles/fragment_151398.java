class Level {
   String name
   Tree parentTree
   Tree owningTree
   Level parentLevel
   Set<Level> subLevels

   static belongsTo = [owningTree: Tree, parentLevel: Level]
   static hasMany = [subLevels: Level]
   static mappedBy = [parentTree: "rootLevel", owningTree: "levels", subLevels: "parentLevel"]

   static constraints = {
       parentTree(nullable: true)
       parentLevel(nullable: true)
   }
}