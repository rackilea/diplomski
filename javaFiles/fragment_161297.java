modelBuilder.begin();
MeshPartBuilder mpb = modelBuilder.part(....);
mpb.rect(...); // first rect.
mpb.rect(...); // second rect.
// etc.
Model model = modelBuilder.end();