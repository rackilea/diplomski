public boolean equals(Object o)
{
  if (o==null || !(o instanceof HudsonJob))
    return false;
  return this.name.toLowerCase().equals(((HudsonJob)o).name.toLowerCase());
}