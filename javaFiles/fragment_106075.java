class Block extends ArrayList<Block> {

    ...

    public Block(int childs) {
        super(childs);
        while (childs > 0)
            add(null);
    }

    private boolean appendBlockIfFound(int atIndex, Block tree, boolean replace) {
        if (size() <= 0)
            return false;

        for (int i = 0; i < size(); i++) {
            Block child = get(i);
            if (child == null)
                continue;
            if (child.index == atIndex) {
                if (replace)
                  set(i, tree);
                return true;
            }
        }

        for (Block child: this)
          if ((child != null) && child.appendBlockIfFound(atIndex, tree, replace))
            return true;

        return false;
    }

    @Override
    public Block set(int index, Block child) {
      super.set(index, child);
      return this;
    }

    ...

}