package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DeptHierachy {
    public Map<String,List<String>> deptMap= new HashMap<>();
    public static void main(String[] args) {
        TreeNode tn=new TreeNode("00");
        tn.addChildTo("00-01", "00");
        tn.addChildTo("00-02", "00");
        tn.addChildTo("00-01-01", "00-01");
        tn.addChildTo("00-01-02", "00-01");
        tn.addChildTo("00-01-03", "00-01");
        tn.addChildTo("00-02-01", "00-02");
        tn.addChildTo("00-02-03", "00-02");
        tn.addChildTo("00-02-03-01", "00-02-03");
        tn.print();
        //System.out.println("max height=" + tn.maxHeigth());
    }



    public static class TreeNode {
          public String value;
          public List<TreeNode> children = new LinkedList<>();

          public TreeNode(String rootValue) {
            value = rootValue;
          }

          public boolean addChildTo(String childName, String parentName) {
              if (parentName.equals(value)) {
                  for (TreeNode child:children) {
                      if (child.getValue().equals(childName)) {
                          throw new IllegalArgumentException(parentName + " already has a child named " + childName);
                      }
                  }
                  children.add(new TreeNode(childName));
                  return true;
              } else {
                  for (TreeNode child:children) {
                      if (child.addChildTo(childName, parentName)) {
                          return true;
                      }
                  }
              }
              return false;
          }

        public String getValue() {
            return value;
        }

        public void print() {
            int maxHeight=maxHeigth();
            System.out.printf("|%-20.20s",value);

            for (int i=0;i<maxHeight-1;i++) {
                System.out.printf("|%-20.20s","");
            }
            System.out.println("|");
            for (TreeNode child:children) {
                child.print(1,maxHeight);
            }
        }

        public void print(int level, int maxHeight) {
            for (int i=0;i<level;i++) {
                System.out.printf("|%-20.20s","");
            }
            System.out.printf("|%-20.20s",value);
            for (int i=level;i<maxHeight-1;i++) {
                System.out.printf("|%-20.20s","");
            }
            System.out.println("|");
            for (TreeNode child:children) {
                child.print(level+1,maxHeight);
            }
        }

        public int maxHeigth() {
            int localMaxHeight=0;
            for (TreeNode child:children) {
                int childHeight = child.maxHeigth();
                if (localMaxHeight < childHeight) {
                    localMaxHeight = childHeight;
                }
            }
            return localMaxHeight+1;
        }
    }   

}