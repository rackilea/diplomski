public void write(PrintStream output) {
        write(overallRoot, "", output);
    }

    private void write(TreeNode root, String code, PrintStream output) {
        if(root != null) {
            if(root.left == null && root.right == null) {
                output.println(root.data + "\n");
            }
            // recursive-case 
            write(root.left, output);
            write(root.right, output);
        }
    }