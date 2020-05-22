interface BranchDestination {
    boolean isLeaf();
  }

  class Node implements BranchDestination {
    private Set branches;
    public boolean isLeaf() {
      return false;
    }
    ...
  }

  class Leaf implements BranchDestination {
    public boolean isLeaf() {
      return true;
    }
    ...
  }

  class Branch {
    BranchDestination destination;
    ...
  }