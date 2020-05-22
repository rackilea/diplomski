public class StringToExcelProblem {

    static String INPUT_DATA = 
              "Information - Desktop | Telecom//Apple Mac//iPhone//Working with iPhone\n"
            + "Infrastructure - Desktop | Telecommunication//Apple iPod//iPad\n"
            + "Information - Desktop | Telecom//Apple Mac//iTunes 10//Settings//Troubleshooting\n";

    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer(INPUT_DATA, "\n");
        List<Block> allBlocks = new ArrayList<>();
        while(st.hasMoreTokens()) {
            String blockData = st.nextToken();
            String[] st2 = blockData.split(" \\| ");
            String parent = st2[0];
            String labels = st2[1];
            StringTokenizer st3 = new StringTokenizer(labels, "//");
            int index = 0;
            Block block = null;
            while(st3.hasMoreTokens()) {
                String label = st3.nextToken();
                if(index == 0){
                    block = new Block(parent, label);
                    index ++;
                } else {
                    block.add(label);
                }
                parent = label;
            }
            allBlocks.add(block);
        }
        for(Block b: allBlocks) {
            for(RowObj r: b.rows){
                System.out.println(r);
            }
            System.out.println();
        }
    }
}

class RowObj {
    String label;
    String value;
    String parentId;
    String active;
    String parentTable;

    @Override
    public String toString() {
        return label + "," + value + "," + parentId + "," + active + "," + parentTable;
    }
}

class Block {
    List<RowObj> rows;

    public Block(String parent, String name) {
        RowObj row = new RowObj();
        row.label = name;
        row.value = name.toLowerCase();
        row.parentId = "Knowledge Base: " + parent;
        row.active = "TRUE";
        row.parentTable = "k_knowledge_base";

        rows = new ArrayList<>();
        rows.add(row);
    }

    public void add(String name) {
        RowObj parent = rows.get(rows.size()-1);

        RowObj row = new RowObj();
        row.label = name;
        row.value = name.toLowerCase();
        row.parentId = "Knowledge Category: " + parent.label;
        row.active = "TRUE";
        row.parentTable = "k_category";

        rows.add(row);
    }

    @Override
    public String toString() {
        return rows.toString();
    }
}