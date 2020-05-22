public static void main(String[] args) throws IOException {

    boolean toExit = false;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BinaryTreeNode binaryTreeNode = new BinaryTreeNode("hello", "hello");
    binaryTreeNode.put("world","world");
    binaryTreeNode.put("ab","ab");
    binaryTreeNode.put("cd","cd");
    while(!toExit) {
      System.out.println("Please enter string to search in the binary search tree or -1 to exit: ");
      String input = bufferedReader.readLine();
      if("-1".equals(input)){
        toExit = true;
      } else {
        if (binaryTreeNode.get(input) == null) {
          System.out.println("The input string does not exist");
        } else {
          System.out.println(input + " exists");
        }
      }

    }
  }

  public static class BinaryTreeNode
  {
    private String key;
    private Object value;
    private BinaryTreeNode left, right;

    public BinaryTreeNode(String key, Object value)
    {
      this.key = key;
      this.value = value;
    }

    public Object get( String key )
    {
      if (this.key.equals(key))
      {
        return value;
      }

      if (key.compareTo(this.key) < 0 )
      {
        return left == null ? null : left.get(key);
      }
      else
      {
        return right == null ? null : right.get(key);
      }
    }

    public void put(String key, Object value)
    {
      if (key.compareTo(this.key) < 0)
      {
        if (left != null)
        {
          left.put(key, value);
        }
        else
        {
          left = new BinaryTreeNode(key, value);
        }
      }
      else if (key.compareTo(this.key) > 0)
      {
        if (right != null)
        {
          right.put(key, value);
        }
        else
        {
          right = new BinaryTreeNode(key, value);
        }
      }
      else
      {
        this.value = value;
      }
    }
  }