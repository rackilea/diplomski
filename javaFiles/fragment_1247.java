@binding-set MyTreeViewBinding
{
    bind "Left"     { "expand-collapse-cursor-row" (0,0,0) };
    bind "Right"    { "expand-collapse-cursor-row" (0,1,0) };
}

GtkTreeView
{
  gtk-key-bindings: MyTreeViewBinding;
}