public class TreeNode implements Comparable<TreeNode>{

    private String nodeUrl;
    private Long id;
    private Boolean folder;
    private transient WebAsset nodeAsset = null; 
}