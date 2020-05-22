void __thiscall mytree::write_page(mytree *this, PAGE *src)
{
  if ( src->isChanged )
  {
    cache::set_changed(this->cache, src->baseAddr);
    src->isChanged = 0;
  }
}